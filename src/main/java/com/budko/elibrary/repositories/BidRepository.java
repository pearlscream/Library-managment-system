package com.budko.elibrary.repositories;

import com.budko.elibrary.entities.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author DBudko.
 */
@Repository
public interface BidRepository extends JpaRepository<Bid,Integer> {
}