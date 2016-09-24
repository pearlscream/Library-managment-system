package com.budko.elibrary.services;

import com.budko.elibrary.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DBudko.
 */
@Service
public interface BookService {
    public List<Book> getAllBooks();
}
