package com.kapx.dvdrental.controller;


import com.kapx.dvdrental.domain.User;
import com.kapx.dvdrental.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/ping", method = GET)
    public String ping() {
        LOGGER.info("--- DVD Rental REST Controller ping method invoked. ---");
        return "DVD Rental REST Controller";
    }

    @RequestMapping(value = "/findAll", method = GET)
    public List<User> findAll() {
        return userService.findAll();
    }

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    public String handleException(Exception e) {
        return e.getMessage();
    }
}
