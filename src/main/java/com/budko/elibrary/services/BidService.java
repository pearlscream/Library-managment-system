package com.budko.elibrary.services;

import com.budko.elibrary.entities.Book;
import com.budko.elibrary.entities.BookCard;
import com.budko.elibrary.entities.User;
import org.springframework.stereotype.Service;

/**
 * @author DBudko.
 */
@Service
public interface BidService {
    public void addBid(User user,BookCard bookCard);

}
