package com.budko.elibrary.services.impl;

import com.budko.elibrary.entities.Bid;
import com.budko.elibrary.entities.Book;
import com.budko.elibrary.entities.BookCard;
import com.budko.elibrary.entities.User;
import com.budko.elibrary.repositories.BidRepository;
import com.budko.elibrary.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;

/**
 * @author DBudko.
 */
@Service
public class BidServiceImpl implements BidService {
    @Autowired
    private BidRepository bidRepository;

    @Override
    public void addBid(User user, BookCard bookCard) {
        Bid bid = new Bid();
        bid.setUser(user);
        bid.setBookCard(bookCard);
        bid.setBidDate(new GregorianCalendar());
        bidRepository.saveAndFlush(bid);
    }
}
