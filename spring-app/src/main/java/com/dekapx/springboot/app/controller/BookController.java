package com.dekapx.springboot.app.controller;

import com.dekapx.springboot.app.dto.BookDto;
import com.dekapx.springboot.app.service.BookService;
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
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @ResponseBody
    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<List<BookDto>> findAll() {
        final List<BookDto> books = this.bookService.findAll();
        log.info("Find all books...");
        return new ResponseEntity<List<BookDto>>(books, HttpStatus.OK);
    }

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    public String handleException(final Exception e) {
        return e.getMessage();
    }
}
