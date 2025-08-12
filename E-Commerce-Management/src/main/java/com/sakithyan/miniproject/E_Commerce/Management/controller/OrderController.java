package com.sakithyan.miniproject.E_Commerce.Management.controller;

import com.sakithyan.miniproject.E_Commerce.Management.dto.OrderDTO;
import com.sakithyan.miniproject.E_Commerce.Management.model.Order;
import com.sakithyan.miniproject.E_Commerce.Management.service.serviceimpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @PostMapping("/{customerId}")
    public String placeOrder(@PathVariable int customerId, @RequestBody OrderDTO orderDTO) {
        return orderService.placeOrder(customerId, orderDTO);
    }

    @GetMapping("/history/{customerId}")
    public List<Order> getOrderHistory(@PathVariable int customerId) {
       return orderService.getOrderHistory(customerId);
    }

    @GetMapping("/{orderId}")
    public OrderDTO getOrderById(@PathVariable int orderId) {
        return orderService.getOrderById(orderId);
    }
}
