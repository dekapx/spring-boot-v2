package com.dekapx.springboot.repository;

import com.dekapx.springboot.domain.ContactAuditEntity;
import com.dekapx.springboot.domain.ContactEntity;
import com.dekapx.springboot.domain.StatusEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        Long id = createContact();
        Assert.assertNotNull(id);

        Long auditId = createAudit(id);
        Assert.assertNotNull(auditId);
    }

    private Long createContact() {
        StatusEntity status = statusRepository.findByStatus("PENDING_AUTHORISED");
        ContactEntity entity = new ContactEntity();
        entity.setFirstName("Test");
        entity.setLastName("Contact");
        entity.setAddress("Dublin, Ireland");
        entity.setEmail("test@gmail.com");
        entity.setPhone("0123456789");
        entity.setStatus(status);
        entity.setModifiedBy("DeKapx");
        contactRepository.save(entity);
        return entity.getId();
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
