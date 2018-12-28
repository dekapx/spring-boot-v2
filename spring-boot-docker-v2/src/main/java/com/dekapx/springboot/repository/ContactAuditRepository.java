package com.dekapx.springboot.repository;

import com.dekapx.springboot.domain.ContactAuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactAuditRepository extends JpaRepository<ContactAuditEntity, Long> {
}
