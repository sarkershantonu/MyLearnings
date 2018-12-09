package org.tutoring.api.service;

import org.tutoring.api.errors.bll.NullIDException;
import org.tutoring.api.model.Course;

import java.util.Collection;

public interface CourseService {

    Collection<Course> viewAll();
    Course findOne(Long id) throws NullIDException;
    Course create(Course aCourse) throws NullIDException;
    Course update(Course aCourse) throws NullIDException;
    void delete(Long id) throws NullIDException;

}
