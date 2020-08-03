package com.dekapx.springboot.app.repository;

import com.dekapx.springboot.app.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByStatusKey(String statusKey);
}

