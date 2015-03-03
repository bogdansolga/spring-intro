package net.safedata.spring.intro.service;

import net.safedata.spring.intro.dao.UserDAO;
import net.safedata.spring.intro.entities.User;

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
