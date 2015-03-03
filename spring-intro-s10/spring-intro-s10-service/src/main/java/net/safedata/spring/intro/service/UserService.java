package net.safedata.spring.intro.service;

import net.safedata.spring.intro.entities.User;
import net.safedata.spring.intro.transport.UserTO;

import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public interface UserService {
    public Collection<UserTO> getAll() throws InterruptedException, ExecutionException;

    public Future<UserTO> get(Integer id) throws InterruptedException;

    public User get(String name);

    public void save(User user);
}
