package net.safedata.spring.intro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/welcome", method = RequestMethod.GET)
public class MVCShowCase {

    private static final String WELCOME_PAGE_NAME = "welcome";

    @RequestMapping("/helloWorld")
    public String welcome(ModelMap model) {
        model.addAttribute("message", "Spring MVC first example");

        return WELCOME_PAGE_NAME;
    }

    @RequestMapping(value = "/{message}")
    public String welcomeEnhanced(@PathVariable String message, ModelMap model) {
        model.addAttribute("message", message);

        return WELCOME_PAGE_NAME;
    }
}
