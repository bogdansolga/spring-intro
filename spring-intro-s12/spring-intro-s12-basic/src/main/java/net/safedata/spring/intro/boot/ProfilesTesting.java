package net.safedata.spring.intro.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@RestController
public class ProfilesTesting {

    @Autowired
    private Environment environment;

    public static void main(String[] args) throws InterruptedException {
        new SpringApplication(ProfilesTesting.class).run(args);
    }

    @RequestMapping("/") String hello() {
        return "The current profiles are '" + Arrays.asList(environment.getActiveProfiles()) + "', the app name is '"
                + environment.getProperty("spring.application.name") + "'";
    }
}