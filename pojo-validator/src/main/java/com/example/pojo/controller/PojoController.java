package com.example.pojo.controller;

import com.example.pojo.model.PojoRequest;
import com.example.pojo.model.PojoRespone;
import com.example.pojo.validator.PropertyValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CONFLICT;

@Slf4j
@RestController
@RequestMapping("/api")
public class PojoController {
    private PropertyValidator<PojoRequest> propertyValidator;

    @PostMapping(value = "/pojo", consumes = "application/json")
    public void save(@RequestBody PojoRequest pojoRequest) {
        propertyValidator.validateFields(pojoRequest);
        log.info("Request " + pojoRequest.toString());
    }

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    public ResponseEntity<PojoRespone> handleException(final Exception e) {
        PojoRespone pojoRespone = new PojoRespone();
        // pojoRespone.(e.getMessage());
        return new ResponseEntity<>(pojoRespone, HttpStatus.BAD_REQUEST);

    }
}
