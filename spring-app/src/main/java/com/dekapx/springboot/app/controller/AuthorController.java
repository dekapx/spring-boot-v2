package com.dekapx.springboot.app.controller;

import com.dekapx.springboot.app.dto.AuthorDto;
import com.dekapx.springboot.app.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CONFLICT;

@Slf4j
@RestController
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @ResponseBody
    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<List<AuthorDto>> findAll() {
        final List<AuthorDto> authors = authorService.findAll();
        log.info("Find all authors...");
        return new ResponseEntity<List<AuthorDto>>(authors, HttpStatus.OK);
    }

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    public String handleException(final Exception e) {
        return e.getMessage();
    }
}
