package com.dekapx.springboot.app.mapper;

import com.dekapx.springboot.app.domain.Book;
import com.dekapx.springboot.app.dto.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements Mapper<Book, BookDto> {
    @Override
    public void copy(Book source, Book target) {

    }

    @Override
    public Book toEntity(BookDto dto) {
        return null;
    }

    @Override
    public BookDto toDto(Book entity) {
        return null;
    }

    @Override
    public String getType() {
        return this.getClass().getTypeName();
    }
}
