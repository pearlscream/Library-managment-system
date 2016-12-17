package com.budko.elibrary.services;

import com.budko.elibrary.entities.BookCard;
import org.springframework.stereotype.Service;

/**
 * @author DBudko.
 */
@Service
public interface BookCardService {
    BookCard getBookCard(int id);
    void addBookCardToBook(Integer id,Integer bookId);
    void removeBookCard(Integer cardId);
}
