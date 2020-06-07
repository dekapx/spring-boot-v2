package com.dekapx.webapp.contact.repository;

import com.dekapx.webapp.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long>, JpaSpecificationExecutor<Contact> {
    Contact findByFirstName(String firstName);

    @Query("SELECT c FROM Contact c WHERE c.status.statusKey = :statusKey")
    List<Contact> findByStatusKey(String statusKey);
}
