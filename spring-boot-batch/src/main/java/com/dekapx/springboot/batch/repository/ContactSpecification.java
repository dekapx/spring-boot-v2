package com.dekapx.springboot.batch.repository;

import com.dekapx.springboot.batch.model.Contact;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ContactSpecification implements Specification<Contact> {
    @Override
    public Predicate toPredicate(final Root<Contact> root, final CriteriaQuery<?> query, final CriteriaBuilder builder) {
        return null;
    }
}
