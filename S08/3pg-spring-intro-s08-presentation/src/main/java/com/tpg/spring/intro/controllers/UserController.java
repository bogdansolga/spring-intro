package com.tpg.spring.intro.controllers;

import com.tpg.spring.intro.entities.User;
import com.tpg.spring.intro.transport.UserTO;
import com.tpg.spring.intro.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.Collection;

@Controller
@RequestMapping("/user")
public class UserController {

    @Inject
    private UserService userService;

    @RequestMapping
    public @ResponseBody Collection<UserTO> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value = "/{id}")
    public @ResponseBody UserTO get(@PathVariable Integer id) {
        return userService.get(id);
    }

    @RequestMapping(value = "/name")
    public @ResponseBody User get(@RequestParam String name) {
        return userService.get(name);
    }
}
