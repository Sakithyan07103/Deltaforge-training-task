package com.weekend3.ecommerce_service.repository;

import com.weekend3.ecommerce_service.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
