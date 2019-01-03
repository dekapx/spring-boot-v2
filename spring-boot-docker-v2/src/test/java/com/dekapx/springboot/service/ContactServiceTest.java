package com.dekapx.springboot.service;

import com.dekapx.springboot.dto.ContactDto;
import com.dekapx.springboot.enums.StatusType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ContactServiceTest {

    @Autowired
    private ContactService contactService;

    @Test
    public void saveAndUpdate() {
        ContactDto contactDto = contactService.save(createDto());
        assertNotNull(contactDto.getId());
        assertEquals(StatusType.PENDING_AUTHORISED.toString(), contactDto.getStatus());

        contactDto = contactService.authorize(contactDto.getId());
        assertNotNull(contactDto.getId());
        assertEquals(StatusType.AUTHORISED.toString(), contactDto.getStatus());
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
