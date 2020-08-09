package com.dekapx.springboot.app.service;

import com.dekapx.springboot.app.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> findAll();
}
