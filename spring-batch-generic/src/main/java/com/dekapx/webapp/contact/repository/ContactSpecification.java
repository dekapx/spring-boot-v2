package com.dekapx.webapp.contact.repository;

import com.dekapx.webapp.contact.model.Contact;
import com.dekapx.webapp.contact.model.Status;
import org.springframework.data.jpa.domain.Specification;

import static com.dekapx.webapp.contact.util.CommonConstants.FIRST_NAME;
import static com.dekapx.webapp.contact.util.CommonConstants.LAST_NAME;
import static com.dekapx.webapp.contact.util.CommonConstants.STATUS;

public class ContactSpecification {

    public static Specification<Contact> compareByFirstName(final String firstName) {
        return (root, query, cb) -> cb.equal(root.get(FIRST_NAME), firstName);
    }

    public static Specification<Contact> compareByLastName(final String lastName) {
        return (root, query, cb) -> cb.equal(root.get(LAST_NAME), lastName);
    }

    public static Specification<Contact> compareByStatus(final Status status) {
        return (root, query, cb) -> cb.equal(root.get(STATUS), status);
    }
}