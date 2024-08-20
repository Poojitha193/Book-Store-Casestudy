package com.ust.customer_service.exceptions;

public class DuplicateCustomerException extends RuntimeException{
    public DuplicateCustomerException(String s){
        super(s);
    }
}
