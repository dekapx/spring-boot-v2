package com.dekapx.springboot.batch.writer;

import com.dekapx.springboot.batch.model.Contact;
import com.dekapx.springboot.batch.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;

@Slf4j
@Component("contactItemWriter")
public class ContactItemWriter implements ItemWriter<Contact> {
    @Autowired
    private ContactService contactService;

    @Override
    public void write(List<? extends Contact> contacts) {
        log.info("-------------- ContactItemWriter.write --------------");
        contacts.forEach(contactConsumer);
    }

    private Consumer<Contact> contactConsumer = (c) -> this.contactService.save(c);
}
