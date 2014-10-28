package com.tpg.spring.intro.service;

import com.tpg.spring.intro.entities.User;

import java.util.Collection;

public interface UserService {
    public User getJohnDoe();

    public Collection<User> getAll();
}
