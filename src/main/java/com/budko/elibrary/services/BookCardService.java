package com.budko.elibrary.services;

import com.budko.elibrary.entities.BookCard;
import org.springframework.stereotype.Service;

/**
 * @author DBudko.
 */
@Service
public interface BookCardService {
    public BookCard getBookCard(int id);
}
