package net.safedata.spring.intro.controllers;

import net.safedata.spring.intro.entities.User;
import net.safedata.spring.intro.transport.UserTO;
import net.safedata.spring.intro.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
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
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public @ResponseBody Collection<UserTO> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value = "/{id}")
    //@PreAuthorize("hasRole('ROLE_USER') AND #id = authentication.details.id")
    public @ResponseBody UserTO get(@PathVariable Integer id) {
        return userService.get(id);
    }

    @RequestMapping(value = "/name")
    public @ResponseBody User get(@RequestParam String name) {
        return userService.get(name);
    }
}
