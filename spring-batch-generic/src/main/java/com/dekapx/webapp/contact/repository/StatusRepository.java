package com.dekapx.webapp.contact.repository;

import com.dekapx.webapp.contact.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByStatusKey(String statusKey);
}
