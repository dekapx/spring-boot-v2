package com.dekapx.springboot.app.service;

import com.dekapx.springboot.app.domain.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class StatusServiceITest {
    @Autowired
    private StatusService statusService;

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenGivenNullInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            statusService.findByStatusKey(null);
        });
        String expectedMessage = "statusKey must not be null or empty.";
        String actualMessage = exception.getMessage();
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenGivenEmptyInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            statusService.findByStatusKey("");
        });
        String expectedMessage = "statusKey must not be null or empty.";
        String actualMessage = exception.getMessage();
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    public void shouldReturnStatusWhenGivenStatusKey() {
        final String statusKey = "STATUS.1";
        final String statusValue = "AUTHORISED";
        Status status = this.statusService.findByStatusKey(statusKey);
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
