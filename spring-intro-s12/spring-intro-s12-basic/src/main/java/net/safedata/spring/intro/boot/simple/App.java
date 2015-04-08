package net.safedata.spring.intro.boot.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {

    public static void main(String[] args) throws InterruptedException {
        new SpringApplication(App.class).run(args);
    }

    @RequestMapping("/") String hello() {
        return "Hello";
    }
}