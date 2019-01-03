package com.dekapx.springboot.command;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;

@Getter
@Builder
public class AuthorizeRequest<R extends JpaRepository, Long> {
    private R repository;
    private Long id;
}
