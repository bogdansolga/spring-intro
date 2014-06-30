package com.tpg.spring.intro.dao;

import com.tpg.spring.intro.entities.User;

public class UserDAOImpl implements UserDAO {

    @Override
    public User getJohnDoe() {
        User user = new User();

        user.setUserId(99);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setUserName("johndoe");
        user.setAge(20);

        return user;
    }
}
