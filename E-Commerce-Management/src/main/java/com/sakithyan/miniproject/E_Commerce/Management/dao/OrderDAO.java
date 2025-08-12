package com.sakithyan.miniproject.E_Commerce.Management.dao;

import com.sakithyan.miniproject.E_Commerce.Management.model.Customer;
import com.sakithyan.miniproject.E_Commerce.Management.model.Order;
import com.sakithyan.miniproject.E_Commerce.Management.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderDAO {

    @Autowired
    private OrderRepo orderRepo;

    public Order save(Order order) {
        return orderRepo.save(order);
    }

    public Optional<Order> findById(int orderId) {
        return orderRepo.findById(orderId);
    }

    public List<Order> findByCustomer(Customer customer) {
        return orderRepo.findByCustomer(customer);
    }
}
