package com.dekapx.springboot.repository;

import com.dekapx.springboot.domain.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Long> {

    @Query("select se from StatusEntity se where se.status = ?1")
    StatusEntity findByStatus(String status);
}
