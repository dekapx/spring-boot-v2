package com.dekapx.springboot.contact.service;

import com.dekapx.springboot.contact.domain.Contact;
import com.dekapx.springboot.contact.dto.ContactDto;
import org.javers.core.Changes;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.shadow.Shadow;

import java.util.List;

public interface ContactService {
    ContactDto save(ContactDto contactDto);

    ContactDto update(ContactDto contactDto);

    ContactDto findById(Long id);

    void delete(Long id);

    List<Shadow<Contact>> findShadows(ContactDto contactDto);

    List<CdoSnapshot> findSnapshots(ContactDto contactDto);

    Changes findChanges(ContactDto contactDto);
}
