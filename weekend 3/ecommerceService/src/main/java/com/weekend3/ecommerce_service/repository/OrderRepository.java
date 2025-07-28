package com.weekend3.ecommerce_service.repository;

import com.weekend3.ecommerce_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
