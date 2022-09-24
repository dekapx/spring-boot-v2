package com.dekapx.apps.contact.resolver;

import com.dekapx.apps.contact.domain.Contact;
import com.dekapx.apps.contact.service.ContactService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ContactResolver implements GraphQLQueryResolver {
    @Autowired
    private ContactService contactService;

    public Contact findContact(final Long id) {
        return this.contactService.findById(id);
    }

    public List<Contact> findContacts() {
        return this.contactService.findAllContacts();
    }
}
