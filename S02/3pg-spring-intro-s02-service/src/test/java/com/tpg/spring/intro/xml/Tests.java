package com.tpg.spring.intro.xml;

import com.tpg.spring.intro.annotation.ApplicationConfig;
import com.tpg.spring.intro.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tests {
    public static void main(String[] args) {
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-classic-wiring.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        UserService userService = applicationContext.getBean(UserService.class);

        System.out.println("Let's welcome Johnny!");
        System.out.println(userService.getJohnDoe());
    }
}
