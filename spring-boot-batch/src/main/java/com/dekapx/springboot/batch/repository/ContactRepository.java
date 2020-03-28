package com.dekapx.springboot.batch.repository;

import com.dekapx.springboot.batch.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository
        extends JpaRepository<Contact, Long>, JpaSpecificationExecutor<Contact> {
}
