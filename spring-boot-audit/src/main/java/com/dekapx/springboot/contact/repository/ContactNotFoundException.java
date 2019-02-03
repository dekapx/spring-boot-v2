package com.dekapx.springboot.contact.repository;

public class ContactNotFoundException extends RuntimeException {
    private static final String errorMessage = "Contact with ID [ %s ] not found.";

    public ContactNotFoundException(final String contactId) {
        super(String.format(errorMessage, contactId));
    }
}
