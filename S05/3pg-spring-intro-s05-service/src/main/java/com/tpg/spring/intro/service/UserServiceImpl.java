package com.tpg.spring.intro.service;

import com.tpg.spring.intro.dao.UserDAO;
import com.tpg.spring.intro.entities.User;

public class UserServiceImpl implements UserService {

    private UserDAO usersDAO;

    public UserServiceImpl(UserDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    public User getJohnDoe() {
        return usersDAO.getJohnDoe();
    }
}
