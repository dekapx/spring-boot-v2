package com.dekapx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootDockerV2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerV2Application.class, args);
	}
}
