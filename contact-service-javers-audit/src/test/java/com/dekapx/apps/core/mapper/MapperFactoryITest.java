package com.dekapx.apps.core.mapper;

import com.dekapx.apps.contact.domain.Contact;
import com.dekapx.apps.contact.mapper.ContactMapper;
import com.dekapx.apps.contact.model.ContactModel;
import com.dekapx.apps.core.exception.ResourceNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class MapperFactoryITest {
    @Autowired
    private MapperFactory mapperFactory;

    @Test
    @DisplayName("Return Mapper for given type")
    public void givenClassTypeShouldReturnMapperInstance() {
        final var mapper = this.mapperFactory.getMapper(Contact.class);
        assertAll(
                () -> assertThat(mapper).isNotNull().isInstanceOf(ContactMapper.class)
        );
    }

    @Test
    @DisplayName("Throw Exception for invalid type")
    public void givenInvalidClassTypeShouldThrowResourceNotFoundException() {
        final var exception = assertThrows(ResourceNotFoundException.class, () -> {
            this.mapperFactory.getMapper(ContactModel.class);
        });
        final var expected = String.format("No mapper found for type [%s]", ContactModel.class.getTypeName());
        assertAll(
                () -> assertThat(exception).isInstanceOf(ResourceNotFoundException.class),
                () -> assertThat(exception.getMessage()).isEqualTo(expected)
        );
    }
}
