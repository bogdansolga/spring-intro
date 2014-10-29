package com.tpg.spring.intro.service;

import com.tpg.spring.intro.dao.UserDAO;
import com.tpg.spring.intro.entities.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Inject
    private UserDAO usersDAO;

    @Override
    public Collection<User> getAll() {
        return usersDAO.getAll();
    }
}
