package com.dekapx.webapp.contact.repository;

import com.dekapx.webapp.contact.model.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StatusRepositoryTest {
    @Autowired
    private StatusRepository statusRepository;

    @Test
    public void shouldReturnStatusWhenGivenStatusKey() {
        Status status = this.statusRepository.findByStatusKey("STATUS.1");
        assertThat(status).isNotNull();
        assertThat(status.getStatusKey()).isNotNull().isEqualTo("STATUS.1");
        assertThat(status.getStatusValue()).isNotNull().isEqualTo("AUTHORISED");
    }
}
