package net.safedata.spring.intro.xml;

import net.safedata.spring.intro.annotation.ApplicationConfig;
import net.safedata.spring.intro.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Tests {
    public static void main(String[] args) {
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-classic-wiring.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        UserService userService = applicationContext.getBean(UserService.class);

        System.out.println("Let's welcome Johnny!");
        System.out.println(userService.getJohnDoe());
    }
}
