package com.dekapx.springboot.contact.service;

import com.dekapx.springboot.contact.dto.ContactDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ContactServiceTest {
    @Autowired(required = true)
    private ContactService contactService;

    @Test
    public void save() {
        contactService.save(createDto());
    }

    private ContactDto createDto() {
        return ContactDto.builder()
                .firstName("De")
                .lastName("Kapx")
                .phone("+353 123 456 7890")
                .email("dekapx@kapxinc.com")
                .modifiedBy("Administrator")
                .build();
    }
}
