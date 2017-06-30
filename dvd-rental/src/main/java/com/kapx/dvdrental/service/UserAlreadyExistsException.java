package com.kapx.dvdrental.service;

public class UserAlreadyExistsException extends RuntimeException {
    private static final String ERROR_MSG = " already exists. Please provide a different username.";

    UserAlreadyExistsException(final String username) {
        super(username + ERROR_MSG);
    }
}
