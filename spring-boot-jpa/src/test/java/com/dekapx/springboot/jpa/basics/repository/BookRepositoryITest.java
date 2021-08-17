package com.dekapx.springboot.jpa.basics.repository;

import com.dekapx.springboot.jpa.basics.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookRepositoryITest {
    private static final String ISBN = "978-0-13-449416-6";
    private static final String TITLE = "Clean Architecture";
    private static final String AUTHOR = "Robert C. Martin";
    private static final String PUBLISHER = "Pearson Education, Inc.";

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void shouldCreateAndReturnBook() {
        this.bookRepository.save(bookSupplier.get());
        final Book book = this.bookRepository.findByTitle(TITLE);
                assertThat(book).isNotNull()
                .satisfies(b -> {
                    assertThat(b.getId()).isNotNull();
                    assertThat(b.getIsbn()).isEqualTo(ISBN);
                    assertThat(b.getTitle()).isEqualTo(TITLE);
                });
    }

    private Supplier<Book> bookSupplier = () -> {
        Book book = new Book();
        book.setIsbn(ISBN);
        book.setTitle(TITLE);
        book.setAuthor(AUTHOR);
        book.setPublisher(PUBLISHER);
        return book;
    };
}
