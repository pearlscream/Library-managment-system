package com.budko.elibrary.services.impl;

import com.budko.elibrary.entities.User;
import com.budko.elibrary.repositories.UserRepository;
import com.budko.elibrary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DBudko.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
