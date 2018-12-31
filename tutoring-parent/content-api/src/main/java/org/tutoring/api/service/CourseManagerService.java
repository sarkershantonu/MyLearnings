package org.tutoring.api.service;

import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.CourseManager;

import java.util.Collection;

public interface CourseManagerService {
    Collection<CourseManager> viewAll() throws InvalidDataException;
    CourseManager findOne(Long id) throws InvalidDataException, InvalidInputException, NullDataException;
    CourseManager create(CourseManager aContent) throws NullDataException, DatabaseUpdateException;
    CourseManager update(CourseManager aContent) throws NullDataException, DatabaseUpdateException;
    Long delete(Long id) throws NullDataException, DatabaseUpdateException;
}
