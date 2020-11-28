package com.dekapx.springboot.contact.repository;

import com.dekapx.springboot.contact.domain.Contact;
import org.javers.spring.annotation.JaversAuditable;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.repository.CrudRepository;

@JaversSpringDataAuditable
public interface ContactRepository extends CrudRepository<Contact, Long> {
    @Override
    @JaversAuditable
    <S extends Contact> S save(S s);
}
