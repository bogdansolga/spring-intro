package net.safedata.spring.intro.dao;

import net.safedata.spring.intro.entities.User;

import java.util.Collection;

public interface UserDAO {
    public User get(Integer id);

    public User get(String name);

    public User addUser(User user);

    public Collection<User> getAll();
}
