package com.budko.elibrary.services.impl;

import com.budko.elibrary.entities.Book;
import com.budko.elibrary.entities.BookCard;
import com.budko.elibrary.repositories.BookCardRepository;
import com.budko.elibrary.repositories.BookRepository;
import com.budko.elibrary.services.BookCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DBudko.
 */
@Service
public class BookCardServiceImpl implements BookCardService {
    @Autowired
    private BookCardRepository bookCardRepository;
    @Autowired
    private BookRepository bookRepository;
    @Override
    public BookCard getBookCard(int id) {
        return bookCardRepository.findOne(id);
    }

    public void addBookCardToBook(Integer id,Integer bookId) {
        Book book = bookRepository.findOne(bookId);
        BookCard bookCard = new BookCard();
        bookCard.setId(id);
        book.getBookCards().add(bookCard);
        bookRepository.saveAndFlush(book);
    }

    @Override
    public void removeBookCard(Integer cardId) {
        bookCardRepository.delete(cardId);
    }
}
