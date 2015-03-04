package net.safedata.spring.intro.service;

import net.safedata.spring.intro.entities.User;
import net.safedata.spring.intro.transport.UserTO;

import java.util.Collection;

public interface UserService {
    public Collection<User> getAll();

    public UserTO get(Integer id);

    public User get(String name);

    public void save(User user);
}
