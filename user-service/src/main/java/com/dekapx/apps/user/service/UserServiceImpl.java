package com.dekapx.apps.user.service;

import com.dekapx.apps.user.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final List<UserModel> users = List.of(
            UserModel.builder()
                    .firstName("De")
                    .lastName("Kapx")
                    .username("dekapx")
                    .email("dekapx@google.com")
                    .build(),
            UserModel.builder()
                    .firstName("Dummy")
                    .lastName("User")
                    .username("dummyuser")
                    .email("dummy.user@google.com")
                    .build());
    @Override
    public List<UserModel> getUsers() {
        log.info("Return all the users");
        return users;
    }

    @Override
    public UserModel getUser(final Long id) {
        log.info("Return the user for ID [{}]", id);
        return users.get(0);
    }
}
