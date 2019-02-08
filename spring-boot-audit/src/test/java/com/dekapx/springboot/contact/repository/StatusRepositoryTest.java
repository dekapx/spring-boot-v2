package com.dekapx.springboot.contact.repository;

import com.dekapx.springboot.contact.domain.StatusEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StatusRepositoryTest {
    @Autowired
    @Qualifier("statusRepository")
    private StatusRepository statusRepository;

    @Test
    public void findbyStatusReturnStatus() {
        final StatusEntity status = getStatus();
        assertNotNull(status);
        assertEquals("PENDING_AUTHORISED", status.getStatus());
    }

    private StatusEntity getStatus() {
        return statusRepository.findByStatus("PENDING_AUTHORISED");
    }
}
