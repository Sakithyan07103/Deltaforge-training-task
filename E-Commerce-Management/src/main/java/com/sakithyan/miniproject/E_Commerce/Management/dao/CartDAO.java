package com.sakithyan.miniproject.E_Commerce.Management.dao;

import com.sakithyan.miniproject.E_Commerce.Management.model.Cart;
import com.sakithyan.miniproject.E_Commerce.Management.model.CartItem;
import com.sakithyan.miniproject.E_Commerce.Management.model.Customer;
import com.sakithyan.miniproject.E_Commerce.Management.repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CartDAO {
    @Autowired
    public CartRepo cartRepo;

    public Cart createCart(Cart cart) {
        return cartRepo.save(cart);
    }

    public boolean existCart(int id) {
        return cartRepo.existsByCartId(id);
    }

    public Optional<Cart> findByCustomer(Customer customer) {
        return cartRepo.findByCustomer(customer);
    }

    public Cart savecart(Cart cart) {
        return cartRepo.save(cart);
    }
}
