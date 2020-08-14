package com.dekapx.springboot.app.service;

import com.dekapx.springboot.app.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto findByTitle(String title);

    List<BookDto> findAll();
}
