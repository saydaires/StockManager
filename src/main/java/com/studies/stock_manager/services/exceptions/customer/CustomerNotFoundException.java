package com.studies.stock_manager.services.exceptions.customer;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message, Throwable error) {
        super(message, error);
    }
}
