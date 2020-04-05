package com.dekapx.springboot.batch.repository;

import com.dekapx.springboot.batch.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>, JpaSpecificationExecutor<Contact> {
    Contact findByFirstName(String firstName);

    @Query("SELECT c FROM Contact c WHERE c.status.statusKey = :statusKey")
    List<Contact> findByStatusKey(String statusKey);
}
