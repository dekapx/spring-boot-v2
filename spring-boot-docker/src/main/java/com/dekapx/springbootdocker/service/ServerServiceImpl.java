package com.dekapx.springbootdocker.service;

import com.dekapx.springbootdocker.domain.ServerEntity;
import com.dekapx.springbootdocker.dto.ServerDto;
import com.dekapx.springbootdocker.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ServerServiceImpl implements ServerService {
    private ServerRepository serverRepository;

    @Autowired
    public ServerServiceImpl(final ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    @Override
    public ServerDto find(final long id) {
        final Optional<ServerEntity> optionalEntity = serverRepository.findById(id);
        return toServerDto(optionalEntity
                .orElseThrow(() -> new ServerNotFoundException(String.valueOf(id))));
    }

    @Override
    public List<ServerDto> findAll() {
        final List<ServerEntity> entities = serverRepository.findAll();
        return entities.stream()
                .map(copyEntityToDto)
                .collect(Collectors.toList());
    }

    private Function<ServerEntity, ServerDto> copyEntityToDto = (entity) -> toServerDto(entity);

    private ServerDto toServerDto(final ServerEntity entity) {
        return ServerDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
