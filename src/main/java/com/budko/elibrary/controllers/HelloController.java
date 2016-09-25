package com.budko.elibrary.controllers;

import com.budko.elibrary.entities.Book;
import com.budko.elibrary.repositories.BookRepository;
import com.budko.elibrary.services.BookService;
import com.budko.elibrary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by dimon on 18.09.2016.
 */
@Controller
public class HelloController {
    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public String index(Model model, @PageableDefault(page = 1,value = 6)Pageable pageable) {
        Page<Book> page = this.bookService.getAllBooks(pageable);
        model.addAttribute("books", page);
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
