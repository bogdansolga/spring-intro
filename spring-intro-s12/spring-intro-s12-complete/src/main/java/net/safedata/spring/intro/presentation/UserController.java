package net.safedata.spring.intro.presentation;

import net.safedata.spring.intro.data.entities.User;
import net.safedata.spring.intro.service.UserService;
import net.safedata.spring.intro.transport.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

@Primary
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public Collection<UserTO> getAll() throws ExecutionException, InterruptedException {
        return userService.getAll();
    }

    @RequestMapping(value = "/{id}")
    public @ResponseBody UserTO get(@PathVariable Integer id) throws InterruptedException, ExecutionException {
        return userService.get(id);
    }

    @RequestMapping(value = "/name")
    public @ResponseBody User get(@RequestParam String name) {
        return userService.get(name);
    }
}
