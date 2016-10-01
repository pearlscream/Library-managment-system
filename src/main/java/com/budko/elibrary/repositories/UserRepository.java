package com.budko.elibrary.repositories;

import com.budko.elibrary.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author DBudko.
 */
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM User u WHERE u.username = ?1")
    public Boolean existsByUsername(String username);
}
