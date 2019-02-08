package com.dekapx.springboot.contact.repository;

import com.dekapx.springboot.contact.domain.ContactEntity;
import com.dekapx.springboot.contact.domain.StatusEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ContactRepositoryTest {
    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    @Test
    public void performContactCrudOperations() {
        ContactEntity contact = new ContactEntity();
        contact.setFirstName("Test");
        contact.setLastName("Contact");
        contact.setEmail("test@gmail.com");
        contact.setPhone("0123456789");
        contact.setModifiedBy("DeKapx");
        contactRepository.save(contact);
        assertNotNull(contact.getId());
    }

}
