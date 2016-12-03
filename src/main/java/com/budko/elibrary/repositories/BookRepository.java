package com.budko.elibrary.repositories;

import com.budko.elibrary.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



/**
 * @author DBudko.
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Page<Book> findByBookNameContaining(String bookName, Pageable pageable);
    Page<Book> findByAuthorsNameContaining(String authorsName, Pageable pageable);
}
