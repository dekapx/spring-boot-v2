package com.dekapx.springboot.command;

import com.dekapx.springboot.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthorizeResponse<E extends BaseEntity> {
    private E entity;
}
