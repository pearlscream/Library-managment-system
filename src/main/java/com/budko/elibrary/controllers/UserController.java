package com.budko.elibrary.controllers;

import com.budko.elibrary.entities.Faculty;
import com.budko.elibrary.entities.User;
import com.budko.elibrary.exceptions.UserExistException;
import com.budko.elibrary.services.FacultyService;
import com.budko.elibrary.services.UserService;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.List;

/**
 * @author DBudko.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private FacultyService facultyService;

    private Logger log = Logger.getLogger(getClass());

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/registration")
    public String registration(Model model) {
        model.addAttribute("user",new User());
        model.addAttribute("faculties",facultyService.getAllFaculties());
        return "registration";
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @Transactional
    public String addUser(@ModelAttribute("user")@Valid User user, BindingResult bindingResult, Model model) throws UserExistException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("faculties",facultyService.getAllFaculties());
            return "registration";
        }
        System.out.println(user);

        userService.saveUser(user);
        return "redirect:/login";
    }
}
