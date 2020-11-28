package com.dekapx.springboot.status.service;

import com.dekapx.springboot.status.domain.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.dekapx.springboot.core.common.CommonConstants.STATUS_AUTHORISED_KEY;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StatusServiceIT {
    @Autowired
    private StatusService statusService;

    @Test
    public void findByStatusKey() {
        Status status = statusService.findByStatusKey(STATUS_AUTHORISED_KEY);
        assertThat(status).isNotNull();
        assertThat(status.getStatusKey())
                .isNotNull()
                .isEqualTo(STATUS_AUTHORISED_KEY);
    }
}
