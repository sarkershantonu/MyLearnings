package org.tutoring.api.service;

import org.tutoring.api.model.CourseManager;

import java.util.Collection;

public interface CourseManagerService {
    Collection<CourseManager> viewAll();
    CourseManager findOne(Long id);
    CourseManager create(CourseManager aContent);
    CourseManager update(CourseManager aContent);
    Long delete(Long id);
}
