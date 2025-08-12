package com.sakithyan.miniproject.E_Commerce.Management.exception.orderexception;

public class OrderDoesNotExistException extends RuntimeException {
    public OrderDoesNotExistException(String message) {
        super(message);
    }
}
