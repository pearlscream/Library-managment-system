package com.budko.elibrary.services;

import com.budko.elibrary.entities.Bid;
import com.budko.elibrary.entities.Book;
import com.budko.elibrary.entities.BookCard;
import com.budko.elibrary.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DBudko.
 */
@Service
public interface BidService {
    void addBid(User user,Book book);
    List<Bid> getAllBids();
}
