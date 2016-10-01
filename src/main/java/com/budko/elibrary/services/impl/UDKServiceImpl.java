package com.budko.elibrary.services.impl;

import com.budko.elibrary.entities.UDKCategory;
import com.budko.elibrary.repositories.UDKRepository;
import com.budko.elibrary.services.UDKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DBudko.
 */
@Service
public class UDKServiceImpl implements UDKService {
    @Autowired
    private UDKRepository udkRepository;

    @Override
    public List<UDKCategory> getAllUDK() {
        return udkRepository.findAll();
    }
}
