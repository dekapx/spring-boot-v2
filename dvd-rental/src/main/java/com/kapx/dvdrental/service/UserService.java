package com.kapx.dvdrental.service;

import com.kapx.dvdrental.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User getById(Long id);

    User saveOrUpdate(User product);

    void delete(Long id);
}
