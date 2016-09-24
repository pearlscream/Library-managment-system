package com.budko.elibrary.repositories;

import com.budko.elibrary.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author DBudko.
 */
@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Integer>{
}
