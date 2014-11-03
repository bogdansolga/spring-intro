package com.tpg.spring.intro.service;

import com.tpg.spring.intro.entities.User;
import com.tpg.spring.intro.transport.UserTO;

import java.util.Collection;

public interface UserService {
    public Collection<User> getAll();

    public UserTO get(Integer id);

    public User get(String name);

    public void save(User user);
}
