package com.dekapx.microservice.contact.service;

public class ContactNotFoundException extends RuntimeException {

    public ContactNotFoundException(final Long id) {
        super("Could not find contact for ID " + id);
    }

}
