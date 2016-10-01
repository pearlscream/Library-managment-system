package com.budko.elibrary.services.impl;

import com.budko.elibrary.entities.Book;
import com.budko.elibrary.repositories.BookRepository;
import com.budko.elibrary.repositories.UDKRepository;
import com.budko.elibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DBudko.
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UDKRepository udkRepository;


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> getAllBooks(Pageable pageable) {
        Pageable request = new PageRequest(pageable.getPageNumber()-1,pageable.getPageSize(),pageable.getSort());
        return bookRepository.findAll(request);
    }

    @Override
    public void addBook(Book book) {
        book.setUdkCategory(udkRepository.findOne(book.getUdkCategory().getId()));
        bookRepository.saveAndFlush(book);
    }
}
