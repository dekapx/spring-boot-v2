package com.dekapx.springboot.batch.repository;

import com.dekapx.springboot.batch.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByStatusKey(String statusKey);
}
