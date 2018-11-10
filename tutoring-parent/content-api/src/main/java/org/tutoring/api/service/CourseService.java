package org.tutoring.api.service;

import org.tutoring.api.model.Course;

import java.util.Collection;

public interface CourseService {

    Collection<Course> viewAll();
    Course findOne(Long id);
    Course create(Course aCourse);
    Course update(Course aCourse);
    Long delete(Long id);

}
