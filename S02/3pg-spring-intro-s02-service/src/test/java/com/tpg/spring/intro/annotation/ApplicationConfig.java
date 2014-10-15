package com.tpg.spring.intro.annotation;

import com.tpg.spring.intro.dao.UserDAO;
import com.tpg.spring.intro.dao.UserDAOImpl;
import com.tpg.spring.intro.service.UserService;
import com.tpg.spring.intro.service.UserServiceImpl;
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
