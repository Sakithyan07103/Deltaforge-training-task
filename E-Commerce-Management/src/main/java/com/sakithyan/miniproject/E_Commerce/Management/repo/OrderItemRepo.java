package com.sakithyan.miniproject.E_Commerce.Management.repo;

import com.sakithyan.miniproject.E_Commerce.Management.model.Order;
import com.sakithyan.miniproject.E_Commerce.Management.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepo extends JpaRepository<OrderItems, Integer> {
    List<OrderItems> findByProductOrder(Order order);
}
