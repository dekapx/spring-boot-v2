package com.dekapx.springboot.app.service;

import com.dekapx.springboot.app.dto.BookDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookServiceITest {
    @Autowired
    private BookService bookService;

    @Test
    public void shouldReturnAllBooks() {
        List<BookDto> books = bookService.findAll();
        assertThat(books)
                .isNotNull()
                .isNotEmpty()
                .hasAtLeastOneElementOfType(BookDto.class);
    }
}
