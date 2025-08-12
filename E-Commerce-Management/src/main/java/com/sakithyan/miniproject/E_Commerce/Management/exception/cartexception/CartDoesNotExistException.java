package com.sakithyan.miniproject.E_Commerce.Management.exception.cartexception;

public class CartDoesNotExistException extends RuntimeException {
    public CartDoesNotExistException(String message) {
        super(message);
    }
}
