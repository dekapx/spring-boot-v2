package com.dekapx.springbootdocker.service;

public class ServerNotFoundException extends RuntimeException {
    private static final String ERROR_MSG = "Unable to find the server for id: ";

    public ServerNotFoundException(final String id) {
        super(ERROR_MSG + id);
    }
}
