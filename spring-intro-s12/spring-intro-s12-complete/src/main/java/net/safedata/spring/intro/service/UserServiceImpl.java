package net.safedata.spring.intro.service;

import net.safedata.spring.intro.data.dao.UserDAO;
import net.safedata.spring.intro.data.entities.User;
import net.safedata.spring.intro.transport.UserTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO usersDAO;

    @Override
    public Collection<UserTO> getAll() throws InterruptedException, ExecutionException {
        Collection<UserTO> userTOs = new LinkedList<>();

        Collection<User> allUsers = usersDAO.getAll();
        for (User user : allUsers) {
            userTOs.add(buildUserTO(user));
        }

        return userTOs;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public UserTO get(Integer id) {
        LOGGER.info("Retrieving the user with the ID '{}'...", id);

        User user = usersDAO.get(id);

        return buildUserTO(user);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public User get(String name) {
        return usersDAO.get(name);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(User user) {
        LOGGER.info("Saving the user '{}'...", user.getUserName());
        usersDAO.save(user);
    }

    private UserTO buildUserTO(User user) {
        UserTO userTO = new UserTO();

        userTO.setId(user.getId());
        userTO.setUserName(user.getUserName());
        userTO.setFirstName(user.getFirstName());
        userTO.setLastName(user.getLastName());

        return userTO;
    }
}
