package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tutoring.api.model.Course;
import org.tutoring.api.repo.CourseRepository;

import java.util.Collection;

public class CourseServiceBean implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Collection<Course> viewAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findOne(Long id) {
        return null;
    }

    @Override
    public Course create(Course aCourse) {
        return null;
    }

    @Override
    public Course update(Course aCourse) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }
}
