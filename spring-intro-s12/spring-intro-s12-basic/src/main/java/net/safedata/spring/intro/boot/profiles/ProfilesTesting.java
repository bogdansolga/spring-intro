package net.safedata.spring.intro.boot.profiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProfilesTesting {

    public static void main(String[] args) throws InterruptedException {
        new SpringApplication(ProfilesTesting.class).run(args);
    }
}