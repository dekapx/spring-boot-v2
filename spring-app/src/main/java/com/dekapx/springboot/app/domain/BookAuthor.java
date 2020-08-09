package com.dekapx.springboot.app.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;

public class BookAuthor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")

    @ManyToOne
    @MapsId("author_id")
    @JoinColumn(name = "author_id")
    Book book;

    @ManyToOne
    @MapsId("author_id")
    @JoinColumn(name = "author_id")
    Author author;
}
