package net.safedata.spring.intro.data.dao;

import net.safedata.spring.intro.data.entities.User;

import java.util.Collection;

public interface UserDAO {
    User get(Integer id);

    User get(String name);

    void addUser(User user);

    Collection<User> getAll();

    void save(User user);
}