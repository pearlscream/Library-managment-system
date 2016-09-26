package com.budko.elibrary.repositories;

import com.budko.elibrary.entities.BookCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author DBudko.
 */
@Repository
public interface BookCardRepository extends JpaRepository<BookCard,Integer> {
}
