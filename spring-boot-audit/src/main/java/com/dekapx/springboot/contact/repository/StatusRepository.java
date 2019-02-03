package com.dekapx.springboot.contact.repository;

import com.dekapx.springboot.contact.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    @Query("select se from Status se where se.status = ?1")
    Status findByStatus(String status);
}
