package com.tpg.spring.intro.service;

import com.tpg.spring.intro.dao.UserDAO;
import com.tpg.spring.intro.entities.User;

/**
 * Implementation of the {@link com.tpg.spring.intro.entities.User} related services
 *
 * @author bogdan.solga
 *
 * Date: 27.06.2014, time: 09:36
 */
public class UserServiceImpl implements UserService {

    private UserDAO usersDAO;

    public void setUsersDAO(UserDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    public User getJohnDoe() {
        return usersDAO.getJohnDoe();
    }
}
