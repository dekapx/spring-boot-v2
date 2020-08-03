package com.dekapx.springboot.app.mapper;

import com.dekapx.springboot.app.domain.Author;
import com.dekapx.springboot.app.dto.AuthorDto;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements Mapper<Author, AuthorDto> {
    @Override
    public Author toEntity(AuthorDto dto) {
        return null;
    }

    @Override
    public AuthorDto toDto(Author entity) {
        return null;
    }
}
