package com.kapx.dvdrental.service;

public class UserNotFoundException extends RuntimeException {
    private static final String ERROR_MSG = "Unable to find the user with username ";

    UserNotFoundException(final String username) {
        super(ERROR_MSG + username);
    }
}
