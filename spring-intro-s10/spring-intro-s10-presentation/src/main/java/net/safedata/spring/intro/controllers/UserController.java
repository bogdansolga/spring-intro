package net.safedata.spring.intro.controllers;

import net.safedata.spring.intro.entities.User;
import net.safedata.spring.intro.service.UserService;
import net.safedata.spring.intro.transport.UserTO;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;
import java.util.concurrent.ExecutionException;

@Primary
@RestController
@RequestMapping("/user")
public class UserController {

    @Inject
    private UserService userService;

    @RequestMapping
    public Collection<UserTO> getAll() throws ExecutionException, InterruptedException {
        return userService.getAll();
    }

    @RequestMapping(value = "/{id}")
    public @ResponseBody UserTO get(@PathVariable Integer id) throws InterruptedException, ExecutionException {
        return userService.get(id).get();
    }

    @RequestMapping(value = "/name")
    public @ResponseBody
    User get(@RequestParam String name) {
        return userService.get(name);
    }
}
