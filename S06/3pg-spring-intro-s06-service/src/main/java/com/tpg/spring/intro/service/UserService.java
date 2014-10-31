package com.tpg.spring.intro.service;

import com.tpg.spring.intro.entities.User;

import java.util.Collection;

public interface UserService {
    public Collection<User> getAll();

    public User get(Integer id);

    public User get(String name);

    public void save(User user, Integer userId);
}
