package com.budko.elibrary.repositories;

import com.budko.elibrary.entities.Book;
import com.budko.elibrary.entities.BookCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author DBudko.
 */
@Repository
public interface BookCardRepository extends JpaRepository<BookCard,Integer> {
    @Query("SELECT bookCard FROM BookCard bookCard where bookCard.book = ?1 AND bookCard.user = null")
    Set<BookCard> getBookCardsByBookInLibrary(Book book);
}
