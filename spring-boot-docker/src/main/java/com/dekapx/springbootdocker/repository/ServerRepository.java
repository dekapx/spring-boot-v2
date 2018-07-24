package com.dekapx.springbootdocker.repository;

import com.dekapx.springbootdocker.domain.ServerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRepository extends JpaRepository<ServerEntity, Long> {
}
