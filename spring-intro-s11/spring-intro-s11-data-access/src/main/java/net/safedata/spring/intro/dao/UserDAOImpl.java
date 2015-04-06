package net.safedata.spring.intro.dao;

import net.safedata.spring.intro.entities.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User get(Integer id) {
        User user = (User) getCurrentSession().get(User.class, id);
        if (user == null) {
            throw new IllegalArgumentException("There is no user with the ID '" + id + "'");
        }

        return user;
    }

    @Override
    public User get(String name) {
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("userName", name));

        List<User> users = criteria.list();
        if (CollectionUtils.isEmpty(users)) {
            throw new IllegalArgumentException("There is no user with the userName '" + name + "'");
        }

        return users.get(0);
    }

    @Override
    public void addUser(User user) {
        getCurrentSession().persist(user);
    }

    @Override
    public Collection<User> getAll() {
        return (Collection<User>) getCurrentSession().createCriteria(User.class).list();
    }

    @Override
    public void save(User user) {
        getCurrentSession().save(user);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
