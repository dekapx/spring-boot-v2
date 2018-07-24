package net.kapil.urlgenerator.service;

public class InvalidUrlException extends RuntimeException {
    public InvalidUrlException(final String message) {
        super(message);
    }

    public InvalidUrlException(final String message, final Exception cause) {
        super(message, cause);
    }
}
