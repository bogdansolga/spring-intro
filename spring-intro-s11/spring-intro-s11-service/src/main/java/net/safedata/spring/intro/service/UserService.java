package net.safedata.spring.intro.service;

import net.safedata.spring.intro.entities.User;
import net.safedata.spring.intro.transport.UserTO;

import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public interface UserService {
    Collection<UserTO> getAll() throws InterruptedException, ExecutionException;

    UserTO get(Integer id);

    User get(String name);

    void save(User user);
}
