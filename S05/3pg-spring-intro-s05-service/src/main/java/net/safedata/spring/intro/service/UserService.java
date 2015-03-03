package net.safedata.spring.intro.service;

import net.safedata.spring.intro.entities.User;

import java.util.Collection;

public interface UserService {
    public User getJohnDoe();

    public Collection<User> getAll();
}
