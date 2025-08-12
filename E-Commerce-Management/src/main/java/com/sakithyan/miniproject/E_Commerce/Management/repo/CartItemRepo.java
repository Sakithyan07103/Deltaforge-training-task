package com.sakithyan.miniproject.E_Commerce.Management.repo;

import com.sakithyan.miniproject.E_Commerce.Management.model.Cart;
import com.sakithyan.miniproject.E_Commerce.Management.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepo extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByCart(Cart cart);
}
