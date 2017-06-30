package com.kapx.dvdrental.service;

import com.kapx.dvdrental.domain.UserEntity;
import com.kapx.dvdrental.dto.UserDto;
import com.kapx.dvdrental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserServiceHelper helper;
    private UserRepository repository;

    @Autowired
    public UserServiceImpl(final UserRepository repository, final UserServiceHelper helper) {
        this.repository = repository;
        this.helper = helper;
    }

    @Override
    public void save(UserDto dto) {
        final Optional<UserEntity> userOptional = repository.findByUsername(dto.getUsername());
        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException(dto.getUsername());
        }
        repository.save(helper.userDtoToEntityCopyFunction.apply(dto));
    }

    @Override
    public void delete(final String username) {
        final Optional<UserEntity> userOptional = repository.findByUsername(username);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException(username);
        }
        repository.delete(userOptional.get());
    }

    @Override
    public UserDto findByUserName(final String username) {
        final Optional<UserEntity> userOptional = repository.findByUsername(username);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException(username);
        }
        return helper.userEntityToDtoCopyFunction.apply(userOptional.get());
    }

    @Override
    public List<UserDto> findAll() {
//        final List<UserDto> users = new ArrayList<>();
//        userRepository.findAll().forEach(users::add);

        final List<UserDto> dtos = new ArrayList<>();
        final List<UserEntity> entities = repository.findAll();
        entities.forEach(entity -> {
            dtos.add(helper.userEntityToDtoCopyFunction.apply(entity));
        });
        return dtos;
    }

}
