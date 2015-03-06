package net.safedata.spring.intro.service;

import net.safedata.spring.intro.entities.User;

import java.util.Collection;

public interface UserService {
    Collection<User> getAll();

    User get(Integer id);

    User get(String name);
}
