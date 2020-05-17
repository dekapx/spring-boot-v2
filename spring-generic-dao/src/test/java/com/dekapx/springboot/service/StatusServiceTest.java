package com.dekapx.springboot.service;

import com.dekapx.springboot.model.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StatusServiceTest {
    @Autowired
    private StatusService statusService;

    @Test
    public void findOne() {
        Status status = statusService.findOne(1L);
        assertThat(status).isNotNull();
        assertThat(status.getStatusKey()).isNotNull().isEqualTo("STATUS.1");
    }
}
