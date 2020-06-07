package com.dekapx.webapp.contact.repository;

import com.dekapx.webapp.contact.model.Contact;
import org.springframework.data.jpa.domain.Specification;

public class ContactSpecification {
    public static Specification<Contact> compareByFirstName(final String firstName) {
        return (root, query, cb) -> cb.equal(root.get("firstName"), firstName);
    }
}