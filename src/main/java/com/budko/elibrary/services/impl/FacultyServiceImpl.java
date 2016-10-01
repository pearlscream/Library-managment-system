package com.budko.elibrary.services.impl;

import com.budko.elibrary.entities.Faculty;
import com.budko.elibrary.repositories.FacultyRepository;
import com.budko.elibrary.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author DBudko.
 */
@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty getFacultyById(Integer id) {
        return facultyRepository.findOne(id);
    }
}
