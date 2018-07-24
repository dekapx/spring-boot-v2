package com.dekapx.springbootdocker.service;

import com.dekapx.springbootdocker.dto.ServerDto;

import java.util.List;

public interface ServerService {
    ServerDto find(long id);

    List<ServerDto> findAll();
}
