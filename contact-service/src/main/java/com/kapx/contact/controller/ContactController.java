package com.kapx.contact.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);

    @RequestMapping("/ping")
    public String ping() {
        LOGGER.info("--- Contact Service REST Controller ping method invoked. ---");
        return "Contact Service REST Controller";
    }

}
