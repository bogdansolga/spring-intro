package com.tpg.spring.intro.controllers;

import com.tpg.spring.intro.entities.User;
import com.tpg.spring.intro.service.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
@RequestMapping("/showcase")
@SuppressWarnings("unused")
public class HTTPAnnotationsShowCaseController {

    @Autowired
    private JSONSerializer jsonSerializer;

    private Random random = new Random();

    @RequestMapping(value = "/user/{userName}", method = RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable String userName) {
        User user = new User();

        user.setFirstName("John");
        user.setLastName("Doe");
        user.setUserName(userName);
        user.setAge(Math.abs(random.nextInt(30)));
        user.setUserId(Math.abs(random.nextInt(1000)));

        return user;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String createUser(@RequestBody User user) {
        // TODO implement
        return "OK";
        //return "{\"message\": \"OK\"}";
    }

    @RequestMapping(value = "/responseEntity", method = RequestMethod.GET)
    public ResponseEntity<String> getUser() {
        return new ResponseEntity<>("Response entity sampler", HttpStatus.OK);
    }

    @RequestMapping(value = "/badRequest", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody String badRequest() {
        return "Bad request";
    }

    @RequestMapping(value = "/throw", method = RequestMethod.GET)
    public @ResponseBody String throwException(@RequestParam String message) {
        throw  new IllegalArgumentException(message);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT)
    public @ResponseBody String illegalArgument(IllegalArgumentException e) {
        return e.getMessage();
    }
}
