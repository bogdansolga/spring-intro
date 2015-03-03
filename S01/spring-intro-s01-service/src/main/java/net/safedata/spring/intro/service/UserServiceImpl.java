package net.safedata.spring.intro.service;

import net.safedata.spring.intro.dao.UserDAO;
import net.safedata.spring.intro.entities.User;

/**
 * Implementation of the {@link net.safedata.spring.intro.entities.User} related services
 *
 * @author bogdan.solga
 *
 * Date: 27.06.2014, time: 09:36
 */
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
