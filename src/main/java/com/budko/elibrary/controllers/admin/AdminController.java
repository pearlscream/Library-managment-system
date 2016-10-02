package com.budko.elibrary.controllers.admin;

import com.budko.elibrary.controllers.dto.BookDTO;
import com.budko.elibrary.entities.Author;
import com.budko.elibrary.exceptions.FileExistException;
import com.budko.elibrary.services.BookService;
import com.budko.elibrary.services.UDKService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

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

    @Autowired
    private Environment environment;

    private Logger log = Logger.getLogger(this.getClass());

    @RequestMapping("/addBook")
    public String addBook(Model model) {
        BookDTO book = new BookDTO();
        book.setAuthors(new ArrayList<>());
        book.getAuthors().add(new Author("","",""));
        model.addAttribute("book",book);
        model.addAttribute("udk",udkService.getAllUDK());
        return "addBook";
    }

    @RequestMapping("/saveBook")
    public String saveBook(@ModelAttribute("book")@Valid BookDTO book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("udk",udkService.getAllUDK());
            return "addBook";
        }
        try {
            bookService.addBook(book);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "File uploaded failed:";
        } catch (IOException e) {
            e.printStackTrace();
            return "File uploaded failed:";
        } catch (FileExistException e) {
            log.warn("File exist");
            saveBook(book,bindingResult,model);
        }
//        return "redirect:/";
        return "addBook";
    }

}
