package com.dekapx.springboot.command;

import com.dekapx.springboot.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;

@Getter
@Builder
public class SaveRequest<R extends JpaRepository, E extends BaseEntity> {
    private R repository;
    private E entity;
}
