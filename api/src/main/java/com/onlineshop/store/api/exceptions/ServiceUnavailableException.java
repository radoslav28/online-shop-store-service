package com.onlineshop.store.api.exceptions;

public class ServiceUnavailableException extends RuntimeException{
    public ServiceUnavailableException() {
        super("Unable to perform request. Try again later.");
    }
}
