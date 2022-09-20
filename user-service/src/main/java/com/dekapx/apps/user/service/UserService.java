package com.dekapx.apps.user.service;


import com.dekapx.apps.user.model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> getUsers();

    UserModel getUser(Long id);
}
