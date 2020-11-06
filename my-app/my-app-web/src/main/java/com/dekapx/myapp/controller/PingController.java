package com.dekapx.myapp.controller;

import com.dekapx.myapp.service.GreetingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CONFLICT;

@Slf4j
@RestController
@RequestMapping("/api")
public class PingController {
    @Autowired
    private GreetingService greetingService;

    @GetMapping(value = "/ping", produces = "application/json")
    public ResponseEntity<String> ping() {
        log.info("PingController invoked...");
        return new ResponseEntity<String>(this.greetingService.sayHello(), HttpStatus.OK);
    }

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    public String handleException(final Exception e) {
        return e.getMessage();
    }
}
