package com.budko.elibrary.services;

import com.budko.elibrary.controllers.dto.BookDTO;
import com.budko.elibrary.entities.Book;
import com.budko.elibrary.exceptions.FileExistException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author DBudko.
 */
@Service
public interface BookService {
    public List<Book> getAllBooks();
    public Page<Book> getAllBooks(Pageable pageable);
    public void addBook(BookDTO book) throws IOException, FileExistException;
}
