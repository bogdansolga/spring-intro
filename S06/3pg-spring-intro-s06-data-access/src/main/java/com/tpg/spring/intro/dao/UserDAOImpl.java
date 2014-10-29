package com.tpg.spring.intro.dao;

import com.tpg.spring.intro.entities.User;
import org.springframework.stDatereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDAOImpl implements UserDAO {

    private Map<Integer, User> byId = new HashMap<>();

    private Map<String, User> byName = new HashMap<>();

    @PostConstruct
    private void init() {
        User user1 = new User("Florin", "Jurcovici", "florin");
        User user2 = new User("Natalia", "Lazar", "natalia");

        addUser(user1);
        addUser(user2);
    }

    @Override
    public User get(Integer id) {
        return byId.get(id);
    }

    @Override
    public User get(String name) {
        return byName.get(name);
    }

    @Override
    public User addUser(User user) {
        if (user.getUserId() == null) {
            user.setUserId(byId.size());
        }

        byId.put(user.getUserId(), user);
        byName.put(user.getUserName(), user);

        return user;
    }

    @Override
    public Collection<User> getAll() {
        return byId.values();
    }
}
