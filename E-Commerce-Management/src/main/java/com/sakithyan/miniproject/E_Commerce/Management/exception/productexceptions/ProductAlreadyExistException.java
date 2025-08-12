package com.sakithyan.miniproject.E_Commerce.Management.exception.productexceptions;

public class ProductAlreadyExistException extends RuntimeException {
    public ProductAlreadyExistException(String message) {
        super(message);
    }
}
