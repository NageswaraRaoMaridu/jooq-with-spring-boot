/*
 * Copyright (c) 2018, Synopsys, Inc. All rights reserved worldwide.
 */

package com.nrmaridu.jooqdemo.repositories;

import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.nrmaridu.jooqdemo.configuration.JooQJdbcImpl;
import com.nrmaridu.jooqdemo.model.User;

/**
 * @author nrmaridu on 5/2/2019
 */
@JooqTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {JooQJdbcImpl.class, UserRepository.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        User user = new User(UUID.randomUUID(), "nrmaridu", 20, "Developer");
        User createdUser = userRepository.createUser(user);
        Assert.assertEquals(createdUser, user);
    }

    //

    @Test
    public void testGetUserById() {
        //User user = new User(UUID.randomUUID(), "nrmaridu", 20, "Developer");
        UUID id = UUID.fromString("3abb5490-04e5-4b4b-b17c-664154d8eee5");
        User user = userRepository.getUserById(id);
        Assert.assertNotNull("User should not be null", user);
    }



    @Test
    public void testGetUserNames() {
        List<String> userNames = userRepository.getUserNames();
        Assert.assertEquals(2, userNames.size());
    }
}
