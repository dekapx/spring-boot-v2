package com.dekapx.springboot.app.mapper;

import com.dekapx.springboot.app.domain.Author;
import com.dekapx.springboot.app.domain.Book;
import com.dekapx.springboot.core.util.BeanUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MapperFactoryITest {
    @Autowired
    private BeanUtils beanUtils;

    @Test
    public void givenMapperTypeShouldReturnMapper() {
        Mapper bookMapper = this.beanUtils.getMapper(Book.class);
        assertThat(bookMapper)
                .isNotNull()
                .isInstanceOf(BookMapper.class);

        Mapper authorMapper = this.beanUtils.getMapper(Author.class);
        assertThat(authorMapper)
                .isNotNull()
                .isInstanceOf(AuthorMapper.class);
    }
}
