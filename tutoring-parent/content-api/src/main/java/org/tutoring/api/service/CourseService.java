package org.tutoring.api.service;

import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.Course;

import java.util.Collection;

public interface CourseService {

    Collection<Course> viewAll() throws InvalidDataException;
    Course findOne(Long id) throws NullDataException, InvalidInputException, InvalidDataException;
    Course create(Course aCourse) throws NullDataException, DatabaseUpdateException;
    Course update(Course aCourse) throws NullDataException, DatabaseUpdateException;
    Long delete(Long id) throws NullDataException, DatabaseUpdateException;

}
