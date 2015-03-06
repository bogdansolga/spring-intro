package net.safedata.spring.intro.service;

import net.safedata.spring.intro.dao.UserDAO;
import net.safedata.spring.intro.entities.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class UserServiceImpl implements UserService {

    @Inject
    private UserDAO usersDAO;

    @Override
    public Collection<User> getAll() {
        return usersDAO.getAll();
    }

    @Override
    public User get(Integer id) {
        return usersDAO.get(id);
    }

    @Override
    public User get(String name) {
        return usersDAO.get(name);
    }

    @Override
    public void bindReqRespParams(HttpServletRequest request, HttpServletResponse response) {
        // TODO do something
    }
}
