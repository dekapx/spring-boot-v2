package com.kapx.dvdrental.service;

import com.kapx.dvdrental.domain.User;
import com.kapx.dvdrental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        final List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User getById(final Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User saveOrUpdate(final User product) {
        return userRepository.save(product);
    }

    @Override
    public void delete(final Long id) {
        userRepository.delete(id);
    }
}
