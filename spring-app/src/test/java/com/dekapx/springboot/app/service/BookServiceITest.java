package com.dekapx.springboot.app.service;

import com.dekapx.springboot.app.dto.BookDto;
import com.dekapx.springboot.core.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenGivenNullInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.bookService.findByTitle(null);
        });
        String expectedMessage = "title must not be null or empty.";
        String actualMessage = exception.getMessage();
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenGivenEmptyInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.bookService.findByTitle("");
        });
        String expectedMessage = "title must not be null or empty.";
        String actualMessage = exception.getMessage();
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    public void shouldReturnBookForGivenTitleThrowResourceNotFoundException() {
        String title = "Dummy Title";
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            this.bookService.findByTitle(title);
        });
        String expectedMessage = "Unable to find the book for title [ " + title + " ]";
        String actualMessage = exception.getMessage();
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    public void shouldReturnBookForGivenTitle() {
        String title = "Effective Java, Third Edition";
        final BookDto bookDto = this.bookService.findByTitle(title);
        assertThat(bookDto)
                .isNotNull();
        assertThat(bookDto.getTitle())
                .isNotNull()
                .isEqualTo(title);
    }
}
