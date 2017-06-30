package com.kapx.dvdrental.service;

import com.kapx.dvdrental.dto.UserDto;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceIT {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByUserName_withInvalidUsername_throwUserNotFoundException() {
        final String username = "invaild-user";
        thrown.expect(UserNotFoundException.class);
        thrown.expectMessage("Unable to find the user with username " + username);
        userService.findByUserName(username);
    }

    @Test
    public void findByUserName_withValidUsername_returnUserDto() {
        final UserDto userDto = userService.findByUserName("dekapx");
        assertThat(userDto, is(notNullValue()));
        assertThat(userDto.getUsername(), is(equalTo("dekapx")));
    }
}
