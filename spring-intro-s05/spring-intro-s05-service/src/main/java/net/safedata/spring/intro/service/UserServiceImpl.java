package net.safedata.spring.intro.service;

import net.safedata.spring.intro.dao.UserDAO;
import net.safedata.spring.intro.entities.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Inject
    private UserDAO usersDAO;

    @Override
    public User getJohnDoe() {
        return usersDAO.getJohnDoe();
    }

    @Override
    public Collection<User> getAll() {
        return usersDAO.getAll();
    }
}
