package com.kapx.dvdrental.repository;

import com.kapx.dvdrental.domain.UserEntity;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Ignore
    @Test
    public void create() throws Exception {
        // Arrange
        UserEntity user = new UserEntity();
        user.setUsername("dummyuser");
        user.setFirstName("dummy");
        user.setLastName("user");
        user.setEmail("dummy.user@dvd-rental.com");
        user.setActive(true);
        user.setCreateDate(new Date());

        // Act
        user = userRepository.save(user);

        // Assert
        assertThat(user.getId(), is(notNullValue()));
    }

    @Test
    public void find() throws Exception {
        final Optional<UserEntity> userOptional = userRepository.findByUsername("dekapx");
        final UserEntity user = userOptional.get();
        assertThat(user.getId(), is(notNullValue()));
        assertThat(user.getUsername(), is(equalTo("dekapx")));
    }

    @Ignore
    @Test
    public void remove() throws Exception {
        final Optional<UserEntity> userOptional = userRepository.findByUsername("dummyuser");
        final UserEntity user = userOptional.get();
        userRepository.delete(user);
        assertThat(userRepository.findOne(user.getId()), is(nullValue()));
    }
}
