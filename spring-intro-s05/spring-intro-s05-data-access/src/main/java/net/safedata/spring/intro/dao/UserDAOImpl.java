package net.safedata.spring.intro.dao;

import net.safedata.spring.intro.entities.User;
import org.springframework.stereotype.Repository;

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
        User user1 = new User("Florin", "Wurst", "florin");
        User user2 = new User("Razvan", "Glimbocaner", "razvan1");
        User user3 = new User("Razvan", "PokerFace", "razvan2");
        User user4 = new User("Andreea", "Minion", "andreea");

        addUser(user1);
        addUser(user2);
        addUser(user3);
        addUser(user4);
    }

    @Override
    public User getJohnDoe() {
        User user = new User();

        user.setUserId(99);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setUserName("johndoe");

        return user;
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
