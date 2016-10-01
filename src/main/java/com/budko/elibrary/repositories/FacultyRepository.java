package com.budko.elibrary.repositories;

import com.budko.elibrary.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author DBudko.
 */
@Repository
@Transactional
public interface FacultyRepository extends JpaRepository<Faculty,Integer>{
}
