package net.safedata.spring.intro.boot.profiles.presentation;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("kitty")
@RestController
public class TestKittyController {

    @RequestMapping("/") String helloKitty() {
        return "on kitty profile";
    }
}
