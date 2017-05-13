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
    public User getById(Long id) {
        // TODO:
        return null;
    }

    @Override
    public User saveOrUpdate(User product) {
        // TODO:
        return null;
    }

    @Override
    public void delete(Long id) {
        // TODO:
    }
}
