package com.budko.elibrary.services;

import com.budko.elibrary.entities.Book;
import com.budko.elibrary.entities.BookCard;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author DBudko.
 */
@Service
public interface BookCardService {
    BookCard getBookCard(int id);
    Set<BookCard> getBookCardByBookInLibrary(Book book);
    void addBookCardToBook(Integer id,Integer bookId);
    void removeBookCard(Integer cardId);
    void saveBookCard(BookCard bookCard);
    List<BookCard> getDebtorsBookCards();
    void removeDebtor(Integer cardId);
}
