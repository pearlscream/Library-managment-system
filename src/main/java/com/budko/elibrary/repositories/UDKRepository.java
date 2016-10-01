package com.budko.elibrary.repositories;

import com.budko.elibrary.entities.UDKCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author DBudko.
 */
public interface UDKRepository extends JpaRepository<UDKCategory,Integer> {
}
