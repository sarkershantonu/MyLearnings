package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.Course;
import org.tutoring.api.repo.CourseRepository;

import java.util.Collection;

@Transactional(propagation = Propagation.SUPPORTS)
public class CourseServiceBean implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Collection<Course> viewAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findOne(Long id) throws NullDataException {
        if (null == id) {
            throw  new NullDataException(APIMessages.ID_NULL);
        }
        return courseRepository.getOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Course create(Course aCourse) throws NullDataException {
        if (null == aCourse.getId()) {
            throw  new NullDataException(APIMessages.ID_NULL);

        }

        return courseRepository.save(aCourse);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Course update(Course aCourse) throws NullDataException {
        if (null == aCourse.getId()) {

            throw  new NullDataException(APIMessages.ID_NULL);
        }
        return courseRepository.save(aCourse);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(Long id) throws NullDataException {
        if (null == id) {
            throw  new NullDataException(APIMessages.ID_NULL);
        }
        courseRepository.deleteById(id);
    }
}
