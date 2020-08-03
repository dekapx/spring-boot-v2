package com.dekapx.springboot.app.repository;

import com.dekapx.springboot.app.domain.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StatusRepositoryITest {
    @Autowired
    private StatusRepository statusRepository;

    @Test
    public void shouldReturnStatusWhenGivenStatusKey() {
        final String statusKey = "STATUS.1";
        final String statusValue = "AUTHORISED";
        Status status = this.statusRepository.findByStatusKey(statusKey);
        assertThat(status)
                .isNotNull();
        assertThat(status.getStatusKey())
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(statusKey);
        assertThat(status.getStatusValue())
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(statusValue);
    }
}
