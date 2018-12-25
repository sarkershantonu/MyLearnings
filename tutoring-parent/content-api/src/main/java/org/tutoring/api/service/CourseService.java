package org.tutoring.api.service;

import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.Course;

import java.util.Collection;

public interface CourseService {

    Collection<Course> viewAll();
    Course findOne(Long id) throws NullDataException;
    Course create(Course aCourse) throws NullDataException;
    Course update(Course aCourse) throws NullDataException;
    void delete(Long id) throws NullDataException;

}
