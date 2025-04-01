package com.studies.stock_manager.services.exceptions;

public class DelayedRecordException extends RuntimeException {
    public DelayedRecordException(String message, Throwable error) {
        super(message, error);
    }
}
