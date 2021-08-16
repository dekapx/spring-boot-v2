package com.dekapx.apps.contact.repository;

import com.dekapx.apps.contact.domain.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {
    Status findByStatusKey(String statusKey);
}
