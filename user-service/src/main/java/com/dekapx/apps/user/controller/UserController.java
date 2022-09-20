package com.dekapx.apps.user.controller;


import com.dekapx.apps.user.model.UserModel;
import com.dekapx.apps.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserModel> getUser(@PathVariable Long id) {
        log.debug("Return all users...");
        final UserModel userModel = this.userService.getUser(id);
        return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserModel>> getUsers() {
        log.debug("Return all users...");
        final List<UserModel> userModels = this.userService.getUsers();
        return new ResponseEntity<List<UserModel>>(userModels, HttpStatus.OK);
    }
}

