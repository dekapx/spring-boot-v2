package com.dekapx.apps.user.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserModel {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
}
