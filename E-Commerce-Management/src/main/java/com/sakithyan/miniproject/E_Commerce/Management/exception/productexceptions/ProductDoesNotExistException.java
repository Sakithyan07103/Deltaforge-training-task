package com.sakithyan.miniproject.E_Commerce.Management.exception.productexceptions;

public class ProductDoesNotExistException extends RuntimeException {
    public ProductDoesNotExistException(String message) {
        super(message);
    }
}
