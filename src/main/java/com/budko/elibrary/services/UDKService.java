package com.budko.elibrary.services;

import com.budko.elibrary.entities.UDKCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DBudko.
 */
@Service
public interface UDKService {
    public List<UDKCategory> getAllUDK();
}
