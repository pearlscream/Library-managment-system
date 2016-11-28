package com.budko.elibrary.controllers;

import com.budko.elibrary.entities.Book;
import com.budko.elibrary.entities.BookCard;
import com.budko.elibrary.entities.Faculty;
import com.budko.elibrary.entities.User;
import com.budko.elibrary.repositories.BidRepository;
import com.budko.elibrary.repositories.BookRepository;
import com.budko.elibrary.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by dimon on 18.09.2016.
 */
@Controller
public class ContentController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BidService bidService;

    @Autowired
    private BookCardService bookCardService;



    @RequestMapping("/")
    public String index(Model model, @PageableDefault(page = 1,value = 50,direction = Sort.Direction.ASC)Pageable pageable) {
        Page<Book> page = bookService.getAllBooks(pageable);
        model.addAttribute("books", page);
        return "index";
    }


    @RequestMapping("/addBid")
    public String addBid(Model model,@RequestParam(name = "bookId") int bookId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        BookCard bookCard = bookCardService.getBookCard(bookId);
        bidService.addBid(user,bookCard);
        return "redirect:/";
    }

}
