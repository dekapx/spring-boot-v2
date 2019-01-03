package com.dekapx.springboot.service;

import com.dekapx.springboot.dto.ContactDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ContactServiceTest {

    @Autowired
    private ContactService contactService;

    @Test
    public void save() {
        ContactDto contactDto = createDto();
        contactService.save(contactDto);
        Assert.assertTrue(true);
    }

    private ContactDto createDto() {
        return ContactDto.builder()
                .firstName("De")
                .lastName("Kapx")
                .address("Dublin, Ireland")
                .phone("+353 123 456 7890")
                .email("dekapx@kapxinc.com")
                .modifiedBy("Administrator")
                .build();
    }
}
