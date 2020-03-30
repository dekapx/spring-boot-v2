package com.dekapx.springboot.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EnableBatchProcessing
@SpringBootApplication
public class SpringBootBatchApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBatchApplication.class, args);
	}
}
