package com.budko.elibrary.controllers;

import com.budko.elibrary.entities.User;
import com.budko.elibrary.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author DBudko.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private Logger log = Logger.getLogger(getClass());

    @RequestMapping(value = "/registration")
    public String registration(Model model) {
        model.addAttribute("user",new User());
        return "registration";
    }
    @RequestMapping(value = "/addUser")
    public String addUser(@ModelAttribute("user")User user, Model model) {
        log.info("New user registration");
        userService.saveUser(user);
        System.out.println(user.getUsername());
        System.out.println(user.getBirthday());
//        user.setBirthday("20-12.2015");
        return "hello";
    }
}
