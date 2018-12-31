package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.Course;
import org.tutoring.api.repo.CourseRepository;

import java.util.Collection;

import static org.tutoring.api.errors.APIMessages.*;

@Transactional(propagation = Propagation.SUPPORTS)
public class CourseServiceBean implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Collection<Course> viewAll() throws InvalidDataException {
        try {
            return courseRepository.findAll();
        } catch (Exception e) {
            throw new InvalidDataException(NO_RESULT);
        }
    }

    @Override
    public Course findOne(Long id) throws NullDataException, InvalidInputException, InvalidDataException {
        if (null == id) {
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id < 1) {
            throw new InvalidInputException(APIMessages.ID_NOT_PRESENT);
        }

        try {
            return courseRepository.getOne(id);
        }catch (Exception e){
            throw new InvalidDataException(NO_RESULT + e.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Course create(Course aCourse) throws NullDataException, DatabaseUpdateException {
        if (null == aCourse) {
            throw new NullDataException(APIMessages.INVALID_DATA);
        }

        try {
            return courseRepository.save(aCourse);
        } catch (
                Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Course update(Course aCourse) throws NullDataException, DatabaseUpdateException {
        if (null == aCourse) {
            throw new NullDataException(DATA_NULL);
        }
        try {
            if (findOne(aCourse.getId()) != null) {
                return courseRepository.save(aCourse);
            } else {
                throw new InvalidDataException(ID_NOT_PRESENT);
            }
        } catch (Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Long delete(Long id) throws NullDataException, DatabaseUpdateException {
        if (null == id) {
            throw new NullDataException(ID_NULL);
        }

        try {
            if(findOne(id).getId() != null){
                courseRepository.deleteById(id);
                return id;
            }else{
                throw new InvalidDataException(ID_NOT_PRESENT);
            }
        } catch (Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }
}
