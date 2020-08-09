package com.dekapx.springboot.app.service;

import com.dekapx.springboot.app.domain.Book;
import com.dekapx.springboot.app.dto.BookDto;
import com.dekapx.springboot.app.mapper.BookMapper;
import com.dekapx.springboot.app.mapper.Mapper;
import com.dekapx.springboot.app.mapper.MapperFactory;
import com.dekapx.springboot.app.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MapperFactory mapperFactory;

    @Override
    public List<BookDto> findAll() {
        final List<Book> books = this.bookRepository.findAll();
        final Mapper<Book, BookDto> mapper = this.mapperFactory.getMapper(BookMapper.class);
        return books.stream()
                .map(book -> mapToDto(mapper, book))
                .collect(Collectors.toList());
    }

    private BookDto mapToDto(final Mapper<Book, BookDto> mapper, final Book book) {
        return mapper.toDto(book);
    }
}
