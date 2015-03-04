package net.safedata.spring.intro.dao;

import net.safedata.spring.intro.entities.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void init() {
        User user1 = new User("Florin", "Jurcovici", "florin");
        User user2 = new User("Natalia", "Lazar", "natalia");

        addUser(user1);
        addUser(user2);
    }

    @Override
    public User get(Integer id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User get(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM User WHERE userName = ?",
                new Object[]{name}, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User addUser(User user) {
        /*
        if (user.getUserId() == null) {
            user.setUserId(byId.size());
        }

        byId.put(user.getUserId(), user);
        byName.put(user.getUserName(), user);
        */

        return user;
    }

    @Override
    public Collection<User> getAll() {
        return (Collection<User>) sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }
}
