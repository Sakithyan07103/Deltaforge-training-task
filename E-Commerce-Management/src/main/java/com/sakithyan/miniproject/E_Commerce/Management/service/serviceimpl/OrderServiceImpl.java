package com.sakithyan.miniproject.E_Commerce.Management.service.serviceimpl;

import com.sakithyan.miniproject.E_Commerce.Management.exception.cartexception.CartDoesNotExistException;
import com.sakithyan.miniproject.E_Commerce.Management.exception.orderexception.OrderDoesNotExistException;
import com.sakithyan.miniproject.E_Commerce.Management.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import com.sakithyan.miniproject.E_Commerce.Management.dao.CartDAO;
import com.sakithyan.miniproject.E_Commerce.Management.dao.CartItemDAO;
import com.sakithyan.miniproject.E_Commerce.Management.dao.CustomerDAO;
import com.sakithyan.miniproject.E_Commerce.Management.dao.OrderDAO;
import com.sakithyan.miniproject.E_Commerce.Management.dao.ProductDAO;
import com.sakithyan.miniproject.E_Commerce.Management.dto.OrderDTO;
import com.sakithyan.miniproject.E_Commerce.Management.exception.customerexceptions.CustomerHaventRegisteredException;
import com.sakithyan.miniproject.E_Commerce.Management.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private CartItemDAO cartItemDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    OrderMapper orderMapper;


    public String placeOrder(int customerId, OrderDTO orderDTO) {
        Customer customer = customerDAO.findById(customerId)
                .orElseThrow(() -> new CustomerHaventRegisteredException("Customer not found"));

        Cart cart = cartDAO.findByCustomer(customer)
                .orElseThrow(() -> new CartDoesNotExistException("No cart found for this customer"));

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderShippingAddress(orderDTO.getOrderAddress());

        List<OrderItems> orderItemsList = new ArrayList<>();
        double totalPrice = 0;

        for (CartItem cartItem : cart.getCartItems()) {
            OrderItems orderItem = new OrderItems();
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setProductQuantity(cartItem.getCartProductQuantity());
            orderItem.setProductPrice(cartItem.getProduct().getProductPrice() * cartItem.getCartProductQuantity());
            orderItem.setProductOrder(order);

            totalPrice += orderItem.getProductPrice();
            orderItemsList.add(orderItem);
        }

        order.setOrderItems(orderItemsList);
        orderDAO.save(order);

        cartItemDAO.deleteAll(cart.getCartItems());
        cart.getCartItems().clear();
        cart.setTotalPrice(0);
        cartDAO.savecart(cart);

        return "Order placed successfully!";

    }

    public List<Order> getOrderHistory(int customerId) {
        Customer customer = customerDAO.findById(customerId)
                .orElseThrow(() -> new CustomerHaventRegisteredException("Customer not found"));

        return orderDAO.findByCustomer(customer);
    }

    @Transactional
    public OrderDTO getOrderById(int orderId) {
        Order order = orderDAO.findById(orderId).orElseThrow(() -> new OrderDoesNotExistException("Order not found"));
        return orderMapper.orderToOrderDTO(order);
    }
}