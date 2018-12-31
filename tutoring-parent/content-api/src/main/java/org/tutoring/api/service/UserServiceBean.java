package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.User;
import org.tutoring.api.repo.UserRepository;

import java.util.Collection;

import static org.tutoring.api.errors.APIMessages.*;

@Transactional(propagation = Propagation.SUPPORTS)
public class UserServiceBean implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Collection<User> viewAll() throws InvalidDataException {

        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new InvalidDataException(NO_RESULT);
        }
    }

    @Override
    public User findOne(Long id) throws NullDataException, InvalidDataException, InvalidInputException {
        if (null == id) {
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id < 1) {
            throw new InvalidInputException(APIMessages.ID_NOT_PRESENT);
        }

        try {
            return userRepository.getOne(id);
        }catch (Exception e){
            throw new InvalidDataException(NO_RESULT + e.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User create(User aUser) throws NullDataException, InvalidDataException, DatabaseUpdateException {
        if (null == aUser) {
            throw new NullDataException(APIMessages.INVALID_DATA);
        }

        try {
            return userRepository.save(aUser);
        } catch (
                Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User update(User aUser) throws NullDataException, InvalidDataException, DatabaseUpdateException {
        if (null == aUser) {
            throw new NullDataException(DATA_NULL);
        }
        try {
            if (findOne(aUser.getId()) != null) {
                return userRepository.save(aUser);
            } else {
                throw new InvalidDataException(ID_NOT_PRESENT);
            }
        } catch (Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Long delete(Long id) throws NullDataException, InvalidDataException, DatabaseUpdateException {

        if (null == id) {
            throw new NullDataException(ID_NULL);
        }

        try {
            if(findOne(id).getId() != null){
                userRepository.deleteById(id);
                return id;
            }else{
                throw new InvalidDataException(ID_NOT_PRESENT);
            }
        } catch (Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }
}
