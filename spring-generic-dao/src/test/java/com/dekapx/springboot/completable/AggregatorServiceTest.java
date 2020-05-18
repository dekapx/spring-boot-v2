package com.dekapx.springboot.completable;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AggregatorServiceTest {
    @Autowired
    private AggregatorService aggregatorService;

    @Test
    public void aggregateObjects() throws Exception {
        AggregatedResponse response = aggregatorService.aggregate();
        assertThat(response).isNotNull();
        assertThat(response.getEmployee()).isNotNull();
        assertThat(response.getAddress()).isNotNull();
    }
}
