package com.studies.stock_manager.services.exceptions.customer;

public class InvalidLoginException extends RuntimeException {
    public InvalidLoginException(String message, Throwable error) {
        super(message, error);
    }
}
