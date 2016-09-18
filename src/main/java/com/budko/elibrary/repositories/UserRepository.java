package com.budko.elibrary.repositories;

import com.budko.elibrary.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author DBudko.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
