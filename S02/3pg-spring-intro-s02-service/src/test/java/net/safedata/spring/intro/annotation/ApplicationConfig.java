package net.safedata.spring.intro.annotation;

import net.safedata.spring.intro.dao.UserDAO;
import net.safedata.spring.intro.dao.UserDAOImpl;
import net.safedata.spring.intro.service.UserService;
import net.safedata.spring.intro.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    @Bean
    public UserService getUserService() {
        UserServiceImpl userService = new  UserServiceImpl();

        userService.setUsersDAO(getUserDAO());

        return userService;
    }
}
