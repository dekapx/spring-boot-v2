package com.dekapx.springboot.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class BookDto {
    private String title;
    private String isbn;
    private String publisher;
    private List<AuthorDto> authors;
}
