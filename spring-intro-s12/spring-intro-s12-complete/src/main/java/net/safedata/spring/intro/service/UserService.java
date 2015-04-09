package net.safedata.spring.intro.service;

import net.safedata.spring.intro.data.entities.User;
import net.safedata.spring.intro.transport.UserTO;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

public interface UserService {
    Collection<UserTO> getAll();

    UserTO get(Integer id);

    User get(String name);

    void save(User user);
}
