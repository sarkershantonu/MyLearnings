package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tutoring.api.model.CourseManager;
import org.tutoring.api.repo.CourseManagerRepository;

import java.util.Collection;

public class CourseManagerServiceBean implements CourseManagerService {

    @Autowired
    private CourseManagerRepository CourseManagerRepository;

    @Override
    public Collection<CourseManager> viewAll() {
        return CourseManagerRepository.findAll();
    }

    @Override
    public CourseManager findOne(Long id) {
        return null;
    }

    @Override
    public CourseManager create(CourseManager aCourseManager) {
        return null;
    }

    @Override
    public CourseManager update(CourseManager aCourseManager) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }
}
