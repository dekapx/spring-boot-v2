package com.kapx.contact.controller;

import com.kapx.contact.domain.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Contact getContact() {
        return null;
    }

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String ping() {
        LOGGER.info("--- Contact Service REST Controller ping method invoked. ---");
        return "Contact Service REST Controller";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleException(Exception e) {
        return e.getMessage();
    }
}
