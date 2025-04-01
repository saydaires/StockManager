package com.studies.stock_manager.services.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message, Throwable error) {
        super(message, error);
    }
}
