package net.safedata.spring.intro.dao;

import net.safedata.spring.intro.entities.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
        return user;
    }

    @Override
    public Collection<User> getAll() {
        return (Collection<User>) sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }
}
