package com.ust.customer_service.exceptions;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String s){
        super(s);
    }
}
