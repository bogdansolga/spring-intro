package com.tpg.spring.intro.service;

import com.tpg.spring.intro.dao.UserDAO;
import com.tpg.spring.intro.entities.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Collection;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    @Inject
    private UserDAO usersDAO;

    @Override
    public Collection<User> getAll() {
        return usersDAO.getAll();
    }

    @Override
    public User get(Integer id) {
        return usersDAO.get(id);
    }

    @Override
    public User get(String name) {
        return usersDAO.get(name);
    }

    @Override
    public void save(User user, Integer userId) {
        User newUser = new User("ceva", "ceva", "ceva");

        System.out.println(usersDAO.contains(user));
        System.out.println(usersDAO.contains(newUser));

        //usersDAO.merge(user);

        usersDAO.save(user);
    }
}
