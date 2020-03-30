package com.dekapx.springboot.batch.writer;

import com.dekapx.springboot.batch.model.Contact;
import com.dekapx.springboot.batch.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component("contactItemWriter")
public class ContactItemWriter implements ItemWriter<Contact> {
    @Autowired
    private ContactService contactService;

    @Override
    public void write(List<? extends Contact> items) {
        for (Contact contact : items) {
            contactService.save(contact);
            log.info("Save Contact...");
        }
    }
}
