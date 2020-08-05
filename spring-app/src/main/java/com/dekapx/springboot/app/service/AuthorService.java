package com.dekapx.springboot.app.service;

import com.dekapx.springboot.app.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> findAll();
}
