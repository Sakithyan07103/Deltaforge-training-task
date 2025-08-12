package com.sakithyan.miniproject.E_Commerce.Management.dao;

import com.sakithyan.miniproject.E_Commerce.Management.model.Cart;
import com.sakithyan.miniproject.E_Commerce.Management.model.CartItem;
import com.sakithyan.miniproject.E_Commerce.Management.repo.CartItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartItemDAO {
    @Autowired
    private CartItemRepo cartItemRepo;

    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepo.save(cartItem);
    }

    public List<CartItem> saveAllCartItems(List<CartItem> cartItems) {
        return cartItemRepo.saveAll(cartItems);
    }

    public void deleteCartItem(CartItem cartItem) {
        cartItemRepo.delete(cartItem);
    }

    public void deleteById(int cartItemId) {
        cartItemRepo.deleteById(cartItemId);
    }

    public void deleteAll(List<CartItem> cartItems) {
        cartItemRepo.deleteAll(cartItems);
    }

    public List<CartItem> findByCart(Cart cart) {
        return cartItemRepo.findByCart(cart);
    }
}
