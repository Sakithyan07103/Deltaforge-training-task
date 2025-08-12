package com.sakithyan.miniproject.E_Commerce.Management.repo;

import com.sakithyan.miniproject.E_Commerce.Management.model.Cart;
import com.sakithyan.miniproject.E_Commerce.Management.model.CartItem;
import com.sakithyan.miniproject.E_Commerce.Management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepo extends JpaRepository<Cart, Integer> {
    boolean existsByCartId(int id);
    Cart findByCartId(int id);
    Optional<Cart> findByCustomer(Customer customer);
}
