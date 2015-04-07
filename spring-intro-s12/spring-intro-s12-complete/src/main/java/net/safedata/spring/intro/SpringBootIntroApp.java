package net.safedata.spring.intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootIntroApp {

    public static void main(String[] args) {
        new SpringApplication(SpringBootIntroApp.class).run(args);
    }
}
