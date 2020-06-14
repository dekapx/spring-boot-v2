package com.dekapx.springboot.designpatterns.servicelocator.command;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(final String message) {
        super(message);
    }
}
