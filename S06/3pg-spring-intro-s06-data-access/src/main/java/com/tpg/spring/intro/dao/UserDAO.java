package com.tpg.spring.intro.dao;

import com.tpg.spring.intro.entities.User;

import java.util.Collection;

public interface UserDAO {
    public User getJohnDoe();

    public User get(Integer id);

    public User get(String name);

    public User addUser(User user);

    public Collection<User> getAll();
}
