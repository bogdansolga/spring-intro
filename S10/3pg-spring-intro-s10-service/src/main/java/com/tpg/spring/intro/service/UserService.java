package com.tpg.spring.intro.service;

import com.tpg.spring.intro.entities.User;
import com.tpg.spring.intro.transport.UserTO;

import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public interface UserService {
    public Collection<UserTO> getAll() throws InterruptedException, ExecutionException;

    public Future<UserTO> get(Integer id) throws InterruptedException;

    public User get(String name);

    public void save(User user);
}
