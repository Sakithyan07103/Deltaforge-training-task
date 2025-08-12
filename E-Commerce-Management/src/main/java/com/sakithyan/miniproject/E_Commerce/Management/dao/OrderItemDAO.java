package com.sakithyan.miniproject.E_Commerce.Management.dao;

import com.sakithyan.miniproject.E_Commerce.Management.repo.OrderItemRepo;
import org.springframework.stereotype.Repository;
import com.sakithyan.miniproject.E_Commerce.Management.model.Order;
import com.sakithyan.miniproject.E_Commerce.Management.model.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class OrderItemDAO {

    @Autowired
    private OrderItemRepo orderItemsRepo;

    public OrderItems saveOrderItem(OrderItems orderItem) {
        return orderItemsRepo.save(orderItem);
    }

    public List<OrderItems> saveAllOrderItems(List<OrderItems> orderItems) {
        return orderItemsRepo.saveAll(orderItems);
    }

    public List<OrderItems> findByOrder(Order order) {
        return orderItemsRepo.findByProductOrder(order);
    }

    public void deleteOrderItem(OrderItems orderItem) {
        orderItemsRepo.delete(orderItem);
    }

    public void deleteAll(List<OrderItems> orderItems) {
        orderItemsRepo.deleteAll(orderItems);
    }
}
