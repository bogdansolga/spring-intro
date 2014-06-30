package com.tpg.spring.intro;

import com.tpg.spring.intro.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tests {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-classic-wiring.xml");

        UserService userService = applicationContext.getBean(UserService.class);

        System.out.println("Let's welcome Johnny!");
        System.out.println(userService.getJohnDoe());
    }
}
