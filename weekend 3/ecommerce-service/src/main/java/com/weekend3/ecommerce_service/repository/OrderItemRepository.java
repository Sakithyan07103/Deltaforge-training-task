package com.weekend3.ecommerce_service.repository;

import com.weekend3.ecommerce_service.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
