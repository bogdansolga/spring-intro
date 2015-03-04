package net.safedata.spring.intro.service;

import net.safedata.spring.intro.entities.User;

import java.util.Collection;

public interface UserService {
    public Collection<User> getAll();

    public User get(Integer id);

    public User get(String name);
}
