package com.budko.elibrary.services;

import com.budko.elibrary.entities.Faculty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author DBudko.
 */
@Service
public interface FacultyService {
    public List<Faculty> getAllFaculties();
}
