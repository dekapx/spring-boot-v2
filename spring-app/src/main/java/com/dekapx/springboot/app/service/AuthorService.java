package com.dekapx.springboot.app.service;

import com.dekapx.springboot.app.domain.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
}
