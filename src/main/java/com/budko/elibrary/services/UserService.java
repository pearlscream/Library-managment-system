package com.budko.elibrary.services;

import com.budko.elibrary.entities.User;
import org.springframework.stereotype.Service;

/**
 * @author DBudko.
 */
@Service
public interface UserService {
    User getUserByUsername(String username);
    User saveUser(User user);
}
