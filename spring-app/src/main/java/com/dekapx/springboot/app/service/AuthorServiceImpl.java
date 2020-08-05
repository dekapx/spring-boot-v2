package com.dekapx.springboot.app.service;

import com.dekapx.springboot.app.domain.Author;
import com.dekapx.springboot.app.dto.AuthorDto;
import com.dekapx.springboot.app.mapper.AuthorMapper;
import com.dekapx.springboot.app.mapper.Mapper;
import com.dekapx.springboot.app.mapper.MapperFactory;
import com.dekapx.springboot.app.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private MapperFactory mapperFactory;

    @Override
    public List<AuthorDto> findAll() {
        final List<Author> authors = authorRepository.findAll();
        final Mapper<Author, AuthorDto> mapper = this.mapperFactory.getMapper(AuthorMapper.class);
        return authors.stream()
                .map(author -> mapToDto(mapper, author))
                .collect(Collectors.toList());
    }

    private AuthorDto mapToDto(final Mapper<Author, AuthorDto> mapper, final Author author) {
        return mapper.toDto(author);
    }
}
