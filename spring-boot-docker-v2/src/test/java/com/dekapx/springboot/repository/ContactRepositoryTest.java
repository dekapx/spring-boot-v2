package com.dekapx.springboot.repository;

import com.dekapx.springboot.domain.AddressEntity;
import com.dekapx.springboot.domain.ContactAuditEntity;
import com.dekapx.springboot.domain.ContactEntity;
import com.dekapx.springboot.domain.StatusEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ContactRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactAuditRepository auditRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Test
    public void performContactCrudOperations() {
        ContactEntity entity = createContact();
        Assert.assertNotNull(entity);

        Long auditId = createAudit(entity.getId());
        Assert.assertNotNull(auditId);

        entity.setFirstName("modified name");
        contactRepository.save(entity);
    }

    private ContactEntity createContact() {
        StatusEntity status = statusRepository.findByStatus("PENDING_AUTHORISED");
        ContactEntity contact = new ContactEntity();
        contact.setFirstName("Test");
        contact.setLastName("Contact");
        contact.setAddress(createAddress(contact));
        contact.setEmail("test@gmail.com");
        contact.setPhone("0123456789");
        contact.setStatus(status);
        contact.setModifiedBy("DeKapx");
        contactRepository.save(contact);
        return contact;
    }

    private List<AddressEntity> createAddress(ContactEntity contact) {
        AddressEntity address = new AddressEntity();
        address.setHouseNo("One CityQuarter");
        address.setStreet("Athlone Town Centre");
        address.setCity("Athlone");
        address.setZip("N37 XY45");
        address.setCounty("WH");
        address.setCountry("Ireland");
        address.setContact(contact);
        return Arrays.asList(address);
    }

    private Long createAudit(Long entityId) {
        ContactAuditEntity auditEntity = new ContactAuditEntity();
        auditEntity.setEntityId(entityId);
        auditEntity.setFieldName("email");
        auditEntity.setOldValue("test@gmail.com");
        auditEntity.setNewValue("test1@gmail.com");
        auditRepository.save(auditEntity);
        return auditEntity.getId();
    }

    private ContactEntity findById(final Long id) {
        Optional<ContactEntity> optionalEntity = contactRepository.findById(id);
        return optionalEntity.orElseThrow(() -> new ContactNotFoundException(String.valueOf(id)));
    }

    private void delete(final ContactEntity entity) {
        contactRepository.delete(entity);
    }
}
