package com.budko.elibrary.services.impl;

import com.budko.elibrary.entities.Book;
import com.budko.elibrary.repositories.BookRepository;
import com.budko.elibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DBudko.
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
