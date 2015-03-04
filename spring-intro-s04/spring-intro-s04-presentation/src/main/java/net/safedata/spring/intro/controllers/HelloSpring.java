package net.safedata.spring.intro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloSpring {

    @RequestMapping(method = RequestMethod.GET, value = "/helloSpring")
    public @ResponseBody String helloSpring() {
        return "Hello, Spring!";
    }
}
