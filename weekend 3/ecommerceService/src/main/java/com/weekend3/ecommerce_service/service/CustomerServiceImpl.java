package com.weekend3.ecommerce_service.service;

import com.weekend3.ecommerce_service.dto.*;
import com.weekend3.ecommerce_service.model.*;
import com.weekend3.ecommerce_service.repository.*;
import com.weekend3.ecommerce_service.service.serviceInterface.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    public Customer customerLogin(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setCustomerUsername(customerDTO.getCustomerName());
        customer.setCustomerPassword(customer.getCustomerPassword());
        return customerRepository.save(customer);
    }

    public boolean validateLogin(CustomerDTO customerDTO) {
        return customerRepository.findByCustomerUsernameAndCustomerPassword(customerDTO
                .getCustomerName(), customerDTO.getCustomerPassword());
    }

    public Cart createCart(CartDTO cartDTO) {
        Customer customer = customerRepository.findById(cartDTO.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("No customer if available"));
        Cart cart = new Cart();
        cart.setCustomer(customer);
        return cart;
    }

    public CartItem addToCart(CartItemDTO cartItemDTO) {
        Customer customer = customerRepository.findById(cartItemDTO.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not Found"));
        Product product = productRepository.findById(cartItemDTO.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        if (product.getStockQuantity() < cartItemDTO.getQuantity()) {
            return null;
        }

        CartItem item = new CartItem();
        item.setCustomer(customer);
        item.setProduct(product);
        item.setQuantity(cartItemDTO.getQuantity());
        return  cartItemRepository.save(item);
    }

    public List<OrderItem> checkout(OrderItemDTO orderItemDTO) {
        Customer customer = customerRepository.findById(orderItemDTO.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        Cart cart = cartRepository.findById(orderItemDTO.getCartId())
                .orElseThrow(() -> new EntityNotFoundException("Cart is empty"));

        if (cart.getCartItems().isEmpty()) {
            return null;
        }

        Order order = new Order();
        order.setCustomer(customer);

        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : cart.getCartItems()) {
            Product product = cartItem.getProduct();
            int quantity = cartItem.getQuantity();

            if (product.getStockQuantity() < quantity) {
                return null ;
            }

            product.setStockQuantity(product.getStockQuantity() - quantity);
            productRepository.save(product);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(quantity);

            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);
        orderRepository.save(order);

        cart.getCartItems().clear();
        cartRepository.save(cart);

        return orderItems;
    }

    public Order getOrders(OrderDTO orderDTO) {
        return orderRepository.findById(orderDTO.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("No order id"));
    }
}
