package com.dekapx.springboot.app.mapper;

import com.dekapx.springboot.app.domain.Author;
import com.dekapx.springboot.app.domain.Book;

public enum MapperType {
    BOOK {
        public String toString() {
            return getTypeName(Book.class);
        }
    },
    AUTHOR {
        public String toString() {
            return getTypeName(Author.class);
        }
    };

    private static <T> String getTypeName(final Class<T> clazz) {
        return clazz.getTypeName();
    }
}
