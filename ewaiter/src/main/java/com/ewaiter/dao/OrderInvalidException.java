package com.ewaiter.dao;

public class OrderInvalidException extends Exception {
    public OrderInvalidException(String message){
        super(message);
    }
}
