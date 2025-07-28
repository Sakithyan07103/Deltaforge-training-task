package com.weekend3.ecommerce_service.service.serviceInterface;

import com.weekend3.ecommerce_service.dto.CartItemDTO;
import com.weekend3.ecommerce_service.dto.CustomerDTO;
import com.weekend3.ecommerce_service.dto.OrderDTO;
import com.weekend3.ecommerce_service.dto.OrderItemDTO;
import com.weekend3.ecommerce_service.model.CartItem;
import com.weekend3.ecommerce_service.model.Customer;
import com.weekend3.ecommerce_service.model.Order;
import com.weekend3.ecommerce_service.model.OrderItem;

import java.util.List;

public interface CustomerService {

     Customer customerLogin(CustomerDTO customerDTO);

     boolean validateLogin(CustomerDTO customerDTO);

     CartItem addToCart(CartItemDTO cartItemDTO);

     List<OrderItem> checkout(OrderItemDTO orderItemDTO);

     Order getOrders(OrderDTO orderDTO);
}
