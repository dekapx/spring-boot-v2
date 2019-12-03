package com.dekapx.microservice.contact.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CONFLICT;

@RestController
@RequestMapping("/api")
public class PingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PingController.class);

    @GetMapping(value = "/ping", produces = "application/json")
    public String ping() {
        LOGGER.info("PingController.ping() method invoked...");
        return "Hello! This URL is active...";
    }

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    public String handleException(final Exception e) {
        return e.getMessage();
    }
}
