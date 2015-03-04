package net.safedata.spring.intro.service;

import net.safedata.spring.intro.dao.UserDAO;
import net.safedata.spring.intro.entities.Product;
import net.safedata.spring.intro.entities.User;
import net.safedata.spring.intro.transport.UserTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Inject
    private UserDAO usersDAO;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Collection<UserTO> getAll() {
        Collection<User> users = usersDAO.getAll();

        Collection<UserTO> userTOs = new LinkedList<>();
        for (User user : users) {
            userTOs.add(buildUserTO(user));
        }

        return userTOs;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public UserTO get(Integer id) {
        LOGGER.info("Retrieving the user with the ID '{}'...", id);

        User user = usersDAO.get(id);
        if (user == null) {
            return null;
        }

        LOGGER.info("{} has the following products", user.getUserName());
        Set<Product> products = user.getProducts();
        for (Product product : products) {
            LOGGER.info("\t{}", product.getName());
        }

        return buildUserTO(user);
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

    private UserTO buildUserTO(User user) {
        UserTO userTO = new UserTO();

        userTO.setId(user.getId());
        userTO.setUserName(user.getUserName());
        userTO.setFirstName(user.getFirstName());
        userTO.setLastName(user.getLastName());

        return userTO;
    }
}
