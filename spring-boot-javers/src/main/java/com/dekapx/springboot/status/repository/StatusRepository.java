package com.dekapx.springboot.status.repository;

import com.dekapx.springboot.status.domain.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Long> {
    Status findByStatusKey(final String statusKey);
}
