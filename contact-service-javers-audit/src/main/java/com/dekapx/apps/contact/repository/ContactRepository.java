package com.dekapx.apps.contact.repository;

import com.dekapx.apps.contact.domain.Contact;
import org.javers.spring.annotation.JaversAuditable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long>, JpaSpecificationExecutor<Contact> {
    @Override
    @JaversAuditable
    <E extends Contact> E save(E entity);

    @Override
    @JaversAuditable
    void deleteById(Long id);

    @Override
    @JaversAuditable
    void delete(Contact entity);

    Contact findByFirstName(String firstName);
}
