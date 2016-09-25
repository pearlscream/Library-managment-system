package com.budko.elibrary.controllers;

import com.budko.elibrary.entities.User;
import com.budko.elibrary.exceptions.UserExistException;
import com.budko.elibrary.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author DBudko.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private Logger log = Logger.getLogger(getClass());

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping(value = "/registration")
    public String registration(Model model) {
        model.addAttribute("user",new User());
        return "registration";
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user")@Valid User user, BindingResult bindingResult, Model model) throws UserExistException {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.saveUser(user);
//        user.setBirthday("20-12.2015");
        return "redirect:/login";
    }
}
