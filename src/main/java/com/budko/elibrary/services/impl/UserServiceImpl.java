package com.budko.elibrary.services.impl;

import com.budko.elibrary.entities.Faculty;
import com.budko.elibrary.entities.User;
import com.budko.elibrary.entities.enums.UserRoles;
import com.budko.elibrary.exceptions.UserExistException;
import com.budko.elibrary.repositories.FacultyRepository;
import com.budko.elibrary.repositories.UserRepository;
import com.budko.elibrary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author DBudko.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User saveUser(User user) throws UserExistException {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UserExistException();
        }
        Faculty faculty = facultyRepository.findOne(1);
        user.setFaculty(faculty);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(UserRoles.USER);
        user.setEnabled(true);
        return userRepository.saveAndFlush(user);
    }
}
