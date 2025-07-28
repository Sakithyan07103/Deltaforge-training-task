package com.weekend3.ecommerce_service.service;

import com.weekend3.ecommerce_service.dto.ProductDTO;
import com.weekend3.ecommerce_service.mapper.ProductMapper;
import com.weekend3.ecommerce_service.model.*;
import com.weekend3.ecommerce_service.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
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

    public Customer customerLogin(String customerUsername, String customerPassword) {
        Customer customer = new Customer();
        customer.setCustomerUsername(customerUsername);
        customer.setCustomerPassword(customerPassword);
        return customerRepository.save(customer);
    }

    public boolean validateLogin(String customerUsername, String customerPassword) {
        return customerRepository.findByCustomerUsernameAndCustomerPassword(customerUsername, customerPassword);
    }

    public List<ProductDTO> getAllProducts(ProductMapper productMapper) {
        List<Product> products = productRepository.findAll();
        return productMapper.toProductDTOs(products);
    }

    public CartItem addToCart(int customerId, int productId, int cartId, int quantity) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getStockQuantity() < quantity) {
            return null;
        }

        Cart cart = cartRepository.findById(cartId)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setCustomer(customer);
                    return cartRepository.save(newCart);
                });

        CartItem item = new CartItem();
        item.setCart(cart);
        item.setProduct(product);
        item.setQuantity(quantity);

        cartItemRepository.save(item);
        return item;
    }

    public String checkout(int customerId, int cartId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart is empty"));

        if (cart.getCartItems().isEmpty()) {
            return "Cart is empty";
        }

        Order order = new Order();
        order.setCustomer(customer);

        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : cart.getCartItems()) {
            Product product = cartItem.getProduct();
            int quantity = cartItem.getQuantity();

            if (product.getStockQuantity() < quantity) {
                return "Insufficient stock for product: " + product.getProductName();
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

        return "Checkout successful, order placed.";
    }

    public Optional<Order> getOrders(int customerId, int orderId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return orderRepository.findById(orderId);
    }
}
