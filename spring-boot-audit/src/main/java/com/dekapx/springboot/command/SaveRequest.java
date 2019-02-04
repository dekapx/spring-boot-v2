package com.dekapx.springboot.command;

import com.dekapx.springboot.contact.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveRequest {
    private BaseEntity entity;
    private JpaRepository repository;
}
