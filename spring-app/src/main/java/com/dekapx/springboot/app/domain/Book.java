package com.dekapx.springboot.app.domain;

import com.dekapx.springboot.app.mapper.BookMapper;
import com.dekapx.springboot.core.annotation.EntityMapper;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy = "books")
    @OrderBy("firstName")
    private Set<Author> authors = new HashSet<>();
}
