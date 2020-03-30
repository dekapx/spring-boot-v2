package com.dekapx.springboot.batch.reader;

import com.dekapx.springboot.batch.model.Contact;
import com.dekapx.springboot.batch.service.ContactService;
import com.dekapx.springboot.batch.specification.ContactSpecification;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStreamSupport;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component("contactItemReader")
public class ContactItemReader extends ItemStreamSupport implements ItemReader<Contact> {
    @Autowired
    private ContactService contactService;

    private List<Contact> contacts;

    @PostConstruct
    private void init() {
        Specification firstNameSpec = ContactSpecification.compareFirstName("Dummy");
        contacts = contactService.findAll(firstNameSpec);
    }

    @Override
    public Contact read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return contacts.iterator().next();
    }
}
