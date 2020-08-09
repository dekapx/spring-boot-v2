package com.dekapx.springboot.app.domain;

import com.dekapx.springboot.app.mapper.BookMapper;
import com.dekapx.springboot.core.annotation.EntityMapper;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "book")
@EntityMapper(mapperClass = BookMapper.class)
public class Book extends AbstractBaseEntity<String> {
    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "isbn")
    private String isbn;

    @NotNull
    @Column(name = "publisher")
    private String publisher;

    @ManyToMany
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors = new ArrayList<>();
}
