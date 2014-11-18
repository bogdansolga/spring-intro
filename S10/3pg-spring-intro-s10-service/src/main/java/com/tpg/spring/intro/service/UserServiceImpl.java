package com.tpg.spring.intro.service;

import com.tpg.spring.intro.dao.UserDAO;
import com.tpg.spring.intro.entities.User;
import com.tpg.spring.intro.transport.UserTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Inject
    private UserDAO usersDAO;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Collection<UserTO> getAll() throws InterruptedException, ExecutionException {
        Collection<UserTO> userTOs = new LinkedList<>();

        UserService userService = applicationContext.getBean(UserService.class);

        LOGGER.info("Get 1");
        Future<UserTO> first = userService.get(1);

        LOGGER.info("Get 2");
        Future<UserTO> second = userService.get(2);

        LOGGER.info("Get 3");
        Future<UserTO> third = userService.get(3);

        UserTO firstUser = first.get();
        LOGGER.info("Finished 1 - {}", firstUser);


        return userTOs;
    }

    @Async
    @Override
    public Future<UserTO> get(Integer id) throws InterruptedException {
        LOGGER.info("Retrieving the user with the ID '{}'...", id);

        return buildUserTO(new User());
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

    @Async
    private Future<UserTO> buildUserTO(User user) throws InterruptedException {
        UserTO userTO = new UserTO();

        userTO.setId(user.getId());
        userTO.setUserName(user.getUserName());
        userTO.setFirstName(user.getFirstName());
        userTO.setLastName(user.getLastName());

        LOGGER.info("Before");
        Thread.sleep(3000);
        LOGGER.info("After");

        return new AsyncResult<>(userTO);
    }
}
