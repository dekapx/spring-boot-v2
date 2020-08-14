package com.dekapx.springboot.app.mapper;

import com.dekapx.springboot.app.domain.Author;
import com.dekapx.springboot.app.dto.AuthorDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("authorMapper")
public class AuthorMapper implements Mapper<Author, AuthorDto> {
    @Override
    public void copy(final Author source, final Author target) {
        throw new UnsupportedOperationException();
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
    public List<Author> toEntity(final List<AuthorDto> dtos) {
        return dtos
                .stream()
                .map(dto -> toEntity(dto))
                .collect(Collectors.toList());
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
    public List<AuthorDto> toDto(final List<Author> entities) {
        return entities
                .stream()
                .map(e -> toDto(e))
                .collect(Collectors.toList());
    }

    @Override
    public String getType() {
        return this.getClass().getTypeName();
    }
}
