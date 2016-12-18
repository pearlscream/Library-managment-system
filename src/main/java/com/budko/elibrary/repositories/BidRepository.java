package com.budko.elibrary.repositories;

import com.budko.elibrary.entities.Bid;
import com.budko.elibrary.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author DBudko.
 */
@Repository
public interface BidRepository extends JpaRepository<Bid,Integer> {
    @Query("SELECT bid FROM Bid bid,BookCard card where bid.book = card.book AND card.user = null")
    List<Bid> findBidsInLibrary();
}
