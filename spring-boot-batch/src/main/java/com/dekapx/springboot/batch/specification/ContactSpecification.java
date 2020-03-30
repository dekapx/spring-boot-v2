package com.dekapx.springboot.batch.specification;

import com.dekapx.springboot.batch.model.Contact;
import org.springframework.data.jpa.domain.Specification;

public class ContactSpecification {
    public static Specification<Contact> compareFirstName(final String firstName) {
        return (root, query, cb) -> cb.equal(root.get("firstName"), firstName);
    }
}
