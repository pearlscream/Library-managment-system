package com.budko.elibrary.controllers.admin;

import com.budko.elibrary.entities.Author;
import com.budko.elibrary.entities.Book;
import com.budko.elibrary.entities.UDKCategory;
import com.budko.elibrary.entities.User;
import com.budko.elibrary.services.BookService;
import com.budko.elibrary.services.UDKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author DBudko.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private BookService bookService;

    @Autowired
    private UDKService udkService;

    @RequestMapping("/addBook")
    public String addBook(Model model) {
        Book book = new Book();
        book.setAuthors(new ArrayList<>());
        book.getAuthors().add(new Author("","",""));
        model.addAttribute("book",book);
        model.addAttribute("udk",udkService.getAllUDK());
        return "addBook";
    }

    @RequestMapping("/saveBook")
    public String saveBook(@ModelAttribute("book")@Valid  Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("udk",udkService.getAllUDK());
            return "addBook";
        }
        System.out.println(book);
        bookService.addBook(book);
//        return "redirect:/";
        return "addBook";
    }

}
