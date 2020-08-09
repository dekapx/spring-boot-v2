package com.dekapx.springboot.app.domain;

import com.dekapx.springboot.app.mapper.AuthorMapper;
import com.dekapx.springboot.core.annotation.EntityMapper;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "author")
@EntityMapper(mapperClass = AuthorMapper.class)
public class Author extends AbstractBaseEntity<String> {
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();
}
