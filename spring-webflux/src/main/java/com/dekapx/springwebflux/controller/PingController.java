package com.dekapx.springwebflux.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class PingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PingController.class);

    @RequestMapping(value = "/ping", method = GET)
    public String ping() {
        LOGGER.info("--- Contact Service REST Controller ping method invoked. ---");
        return "Spring Webflux Application ping...";
    }
}
