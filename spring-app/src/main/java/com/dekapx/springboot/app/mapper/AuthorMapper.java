package com.dekapx.springboot.app.mapper;

import com.dekapx.springboot.app.domain.Author;
import com.dekapx.springboot.app.dto.AuthorDto;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements Mapper<Author, AuthorDto> {
    @Override
    public void copy(final Author source, final Author target) {

    }

    @Override
    public Author toEntity(final AuthorDto authorDto) {
        final Author author = new Author();
        author.setId(authorDto.getId());
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        return author;
    }

    @Override
    public AuthorDto toDto(final Author author) {
        return AuthorDto.builder()
                .id(author.getId())
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .build();
    }

    @Override
    public String getType() {
        return this.getClass().getTypeName();
    }
}
