package net.safedata.spring.intro.controllers;

import net.safedata.spring.intro.entities.User;
import net.safedata.spring.intro.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.Collection;

@Controller
@RequestMapping("/user")
public class UserController {

    @Inject
    private UserService userService;

    @RequestMapping
    public @ResponseBody Collection<User> getAll() {
        return userService.getAll();
    }
}
