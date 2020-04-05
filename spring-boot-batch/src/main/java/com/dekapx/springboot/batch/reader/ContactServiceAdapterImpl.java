package com.dekapx.springboot.batch.reader;

import com.dekapx.springboot.batch.model.Contact;
import com.dekapx.springboot.batch.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactServiceAdapterImpl implements ContactServiceAdapter {
    @Autowired
    private ContactService contactService;

    @Override
    public List<Contact> loadPendingContacts() {
        return this.contactService.findByStatusKey("STATUS.2");
    }
}
