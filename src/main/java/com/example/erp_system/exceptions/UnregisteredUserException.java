package com.example.erp_system.exceptions;

public class UnregisteredUserException extends RuntimeException{
    public UnregisteredUserException(String message){
        super(message);
    }
}
