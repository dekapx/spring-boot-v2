package com.kapx.dvdrental.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/dvdrental")
public class DvdRentalController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DvdRentalController.class);

    @RequestMapping(value = "/ping", method = GET)
    public String ping() {
        LOGGER.info("--- DVD Rental REST Controller ping method invoked. ---");
        return "DVD Rental REST Controller";
    }

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    public String handleException(Exception e) {
        return e.getMessage();
    }
}
