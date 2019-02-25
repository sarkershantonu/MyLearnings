package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.CourseManager;
import org.tutoring.api.repo.CourseManagerRepository;

import java.util.Collection;

import static org.tutoring.api.errors.APIMessages.*;
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class CourseManagerServiceBean implements CourseManagerService {

    @Autowired
    private CourseManagerRepository courseManagerRepository;

    @Override
    public Collection<CourseManager> viewAll() throws InvalidDataException {

        try {
            return courseManagerRepository.findAll();
        } catch (Exception e) {
            throw new InvalidDataException(NO_RESULT);
        }    }

    @Override
    public CourseManager findOne(Long id) throws InvalidDataException, InvalidInputException, NullDataException {

        if (null == id) {
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id < 1) {
            throw new InvalidInputException(APIMessages.ID_NOT_PRESENT);
        }

        try {
            return courseManagerRepository.getOne(id);
        }catch (Exception e){
            throw new InvalidDataException(NO_RESULT + e.getMessage());
        }
    }

    @Override
    public CourseManager create(CourseManager aCourseManager) throws NullDataException, DatabaseUpdateException {

        if (null == aCourseManager) {
            throw new NullDataException(APIMessages.INVALID_DATA);
        }

        try {
            return courseManagerRepository.save(aCourseManager);
        } catch (
                Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }

    }

    @Override
    public CourseManager update(CourseManager aCourseManager) throws NullDataException, DatabaseUpdateException {
        if (null == aCourseManager) {
            throw new NullDataException(DATA_NULL);
        }
        try {
            if (findOne(aCourseManager.getId()) != null) {
                return courseManagerRepository.save(aCourseManager);
            } else {
                throw new InvalidDataException(ID_NOT_PRESENT);
            }
        } catch (Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }

    @Override
    public Long delete(Long id) throws NullDataException, DatabaseUpdateException {

        if (null == id) {
            throw new NullDataException(ID_NULL);
        }

        try {
            if(findOne(id).getId() != null){
                courseManagerRepository.deleteById(id);
                return id;
            }else{
                throw new InvalidDataException(ID_NOT_PRESENT);
            }
        } catch (Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }
}
