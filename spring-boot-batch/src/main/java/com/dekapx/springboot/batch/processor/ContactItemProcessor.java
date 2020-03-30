package com.dekapx.springboot.batch.processor;

import com.dekapx.springboot.batch.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component("contactItemProcessor")
public class ContactItemProcessor implements ItemProcessor<Contact, Contact> {
    @Override
    public Contact process(Contact contact) throws Exception {
        // TODO: here modify the data
        log.info("process contact");
        return contact;
    }
}
