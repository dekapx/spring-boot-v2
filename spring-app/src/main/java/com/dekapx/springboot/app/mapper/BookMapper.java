package com.dekapx.springboot.app.mapper;

import com.dekapx.springboot.app.domain.Book;
import com.dekapx.springboot.app.dto.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("bookMapper")
public class BookMapper implements Mapper<Book, BookDto> {
    @Override
    public void copy(Book source, Book target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Book toEntity(final BookDto dto) {
        final Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());
        book.setPublisher(dto.getPublisher());
        return book;
    }

    @Override
    public List<Book> toEntity(final List<BookDto> dtos) {
        return dtos
                .stream()
                .map(dto -> toEntity(dto))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto toDto(final Book entity) {
        return BookDto.builder()
                .title(entity.getTitle())
                .isbn(entity.getIsbn())
                .publisher(entity.getPublisher())
                .build();
    }

    @Override
    public List<BookDto> toDto(final List<Book> entities) {
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
