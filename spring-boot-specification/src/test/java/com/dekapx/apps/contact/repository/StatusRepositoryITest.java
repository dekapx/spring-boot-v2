package com.dekapx.apps.contact.repository;

import com.dekapx.apps.contact.domain.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
public class StatusRepositoryITest {
    @Autowired
    private StatusRepository statusRepository;

    @Test
    public void findStatusById() {
        Optional<Status> statusOptional = this.statusRepository.findById(1L);
        assertAll(
                () -> assertThat(statusOptional).isNotEmpty(),
                () -> assertThat(statusOptional.get().getStatusKey()).isEqualTo("STATUS.1"),
                () -> assertThat(statusOptional.get().getStatusValue()).isEqualTo("AUTHORISED")
        );
    }
}
