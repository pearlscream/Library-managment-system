package com.budko.elibrary.services.impl;

import com.budko.elibrary.entities.Book;
import com.budko.elibrary.entities.BookCard;
import com.budko.elibrary.repositories.BookCardRepository;
import com.budko.elibrary.repositories.BookRepository;
import com.budko.elibrary.services.BookCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
        bookCard.setBook(book);
        bookCardRepository.saveAndFlush(bookCard);
       }

    @Override
    public void removeBookCard(Integer cardId) {
        bookCardRepository.delete(cardId);
    }

    @Override
    public Set<BookCard> getBookCardByBookInLibrary(Book book) {
        return bookCardRepository.getBookCardsByBookInLibrary(book);
    }

    @Override
    public void saveBookCard(BookCard bookCard) {
        bookCardRepository.saveAndFlush(bookCard);
    }
}
