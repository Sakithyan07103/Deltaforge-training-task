package com.sakithyan.miniproject.E_Commerce.Management.exception.customerexceptions;

public class RegisterAlreadyExistException extends RuntimeException{

    public RegisterAlreadyExistException(String getMessage) {
        super(getMessage);
    }
}
