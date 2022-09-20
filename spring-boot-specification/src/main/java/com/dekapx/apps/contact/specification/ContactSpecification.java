package com.dekapx.apps.contact.specification;

import com.dekapx.apps.contact.domain.Contact;
import com.dekapx.apps.contact.domain.Status;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

public class ContactSpecification {
    public static Specification<Contact> getContactByFirstName(String name) {
        return (Root<Contact> root, CriteriaQuery<?> query, CriteriaBuilder cb)
                -> cb.equal(root.get("firstName"), name);
    }

    public static Specification<Contact> getContactByLastName(String name) {
        return (Root<Contact> root, CriteriaQuery<?> query, CriteriaBuilder cb)
                -> cb.equal(root.get("lastName"), name);
    }

    public static Specification<Contact> getContactByStatus(Long statusId) {
        return (root, query, cb) -> {
            Join<Contact,Status> join = root.join("status");
            return cb.equal(join.get("id"), statusId);
        };
    }
}
