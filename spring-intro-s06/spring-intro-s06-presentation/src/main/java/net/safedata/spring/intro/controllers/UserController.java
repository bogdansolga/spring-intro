package net.safedata.spring.intro.controllers;

import net.safedata.spring.intro.entities.User;
import net.safedata.spring.intro.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "/{id}")
    public @ResponseBody User get(@PathVariable Integer id) {
        return userService.get(id);
    }

    @RequestMapping(value = "/name")
    public @ResponseBody User get(@RequestParam String name) {
        return userService.get(name);
    }

    @RequestMapping(value = "/bindReqParams")
    public @ResponseBody void bindParams(HttpServletRequest request, HttpServletResponse response) {
        userService.bindReqRespParams(request, response);
    }
}
