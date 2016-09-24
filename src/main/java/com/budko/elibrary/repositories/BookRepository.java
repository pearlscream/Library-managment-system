package com.budko.elibrary.repositories;

import com.budko.elibrary.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author DBudko.
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
