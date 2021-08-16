package com.dekapx.springboot.jpa.basics.repository;

import com.dekapx.springboot.jpa.basics.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookRepositoryITest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void shouldCreateAndReturnBook() {
        final Book book = this.bookRepository.save(bookSupplier.get());
        assertThat(book).isNotNull()
                .satisfies(b -> {
                    assertThat(b.getId()).isNotNull();
                });
    }

    private Supplier<Book> bookSupplier = () -> {
        Book book = new Book();
        book.setIsbn("978-0-13-449416-6");
        book.setTitle("Clean Architecture");
        book.setAuthor("Robert C. Martin");
        book.setPublisher("Pearson Education, Inc.");
        return book;
    };
}
