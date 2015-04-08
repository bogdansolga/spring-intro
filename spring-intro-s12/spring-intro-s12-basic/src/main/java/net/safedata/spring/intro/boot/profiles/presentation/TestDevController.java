package net.safedata.spring.intro.boot.profiles.presentation;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("dev")
@RestController
public class TestDevController {

    @RequestMapping("/") String helloDev() {
        return "on dev profile";
    }
}
