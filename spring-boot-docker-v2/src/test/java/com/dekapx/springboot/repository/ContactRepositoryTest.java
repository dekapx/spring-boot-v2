package com.dekapx.springboot.repository;

import com.dekapx.springboot.domain.ContactEntity;
import com.dekapx.springboot.domain.StatusEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ContactRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Test
    public void performContactCrudOperations() {
        Long id = create();
        Assert.assertNotNull(id);
    }

    private Long create() {
        final StatusEntity status = statusRepository.findByStatus("PENDING_AUTHORISED");
        ContactEntity entity = new ContactEntity();
        entity.setFirstName("Test");
        entity.setLastName("Contact");
        entity.setAddress("Dublin, Ireland");
        entity.setEmail("test@gmail.com");
        entity.setPhone("0123456789");
        entity.setStatus(status);
        entity.setModifiedDate(new Date());
        entity.setModifiedBy("DeKapx");
        entity = contactRepository.save(entity);
        return entity.getId();
    }

    private ContactEntity findById(final Long id) {
        Optional<ContactEntity> optionalEntity = contactRepository.findById(id);
        return optionalEntity.orElseThrow(() -> new ContactNotFoundException(String.valueOf(id)));
    }

    private void delete(final ContactEntity entity) {
        contactRepository.delete(entity);
    }
}
