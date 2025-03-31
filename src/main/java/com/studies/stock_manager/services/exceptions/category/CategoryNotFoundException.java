package com.studies.stock_manager.services.exceptions.category;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String message, Throwable error) {
        super(message, error);
    }
}
