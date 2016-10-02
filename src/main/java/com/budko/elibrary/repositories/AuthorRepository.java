package com.budko.elibrary.repositories;

import com.budko.elibrary.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author DBudko.
 */
public interface AuthorRepository extends JpaRepository<Author,Integer>{
}
