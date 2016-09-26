package com.budko.elibrary.services.impl;

import com.budko.elibrary.entities.BookCard;
import com.budko.elibrary.repositories.BookCardRepository;
import com.budko.elibrary.services.BookCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DBudko.
 */
@Service
public class BookCardServiceImpl implements BookCardService {
    @Autowired
    private BookCardRepository bookCardRepository;
    @Override
    public BookCard getBookCard(int id) {
        return bookCardRepository.findOne(id);
    }
}
