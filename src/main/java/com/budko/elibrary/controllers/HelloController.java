package com.budko.elibrary.controllers;

import com.budko.elibrary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dimon on 18.09.2016.
 */
@Controller
public class HelloController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "hello";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/test")
    public String test() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(userService.getUserByUsername("Dima@mail.ru").getUsername());
        return "test";
    }
}
