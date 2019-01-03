package com.dekapx.springboot.repository;

public class ObjectNotFoundException extends RuntimeException {
    private static final String errorMessage = "Object with ID [ %s ] not found.";

    public ObjectNotFoundException(final String id) {
        super(String.format(errorMessage, id));
    }
}
