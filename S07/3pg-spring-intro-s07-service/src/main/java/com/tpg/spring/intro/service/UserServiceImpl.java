package com.tpg.spring.intro.service;

import com.tpg.spring.intro.dao.UserDAO;
import com.tpg.spring.intro.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Inject
    private UserDAO usersDAO;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Collection<User> getAll() {
        return usersDAO.getAll();
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public User get(Integer id) {
        LOGGER.info("Retrieving the user with the ID '{}'...", id);
        return usersDAO.get(id);
    }

    @Override
    public User get(String name) {
        return usersDAO.get(name);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(User user) {
        LOGGER.info("Saving the user '{}'...", user.getUserName());
        usersDAO.save(user);
    }
}
