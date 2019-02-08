package com.dekapx.springboot.contact.repository;

import com.dekapx.springboot.contact.domain.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
}
