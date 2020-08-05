package com.dekapx.springboot.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CONFLICT;

@Slf4j
@RestController
@RequestMapping("/api")
public class PingController {
    @GetMapping(value = "/ping/{name}", produces = "application/json")
    public ResponseEntity<String> ping(
            @RequestHeader(name = "id") String id,
            @RequestParam(name = "name", defaultValue = "Test") String name) {
        log.info("PingController.ping({}) method invoked by id [{}]...", name, id);
        return new ResponseEntity<String>("Hello ! " + name, HttpStatus.OK);
    }

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    public String handleException(final Exception e) {
        return e.getMessage();
    }
}
