package net.kapil.urlgenerator.service;

public class UrlNotFoundException extends RuntimeException {
    public UrlNotFoundException(final String url) {
        super("Exception: The URL [" + url + "] not found in the database...");
    }
}
