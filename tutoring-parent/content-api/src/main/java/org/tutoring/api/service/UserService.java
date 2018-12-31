package org.tutoring.api.service;

import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.User;

import java.util.Collection;

public interface UserService {

    Collection<User> viewAll() throws InvalidDataException;
    User findOne(Long id) throws NullDataException, InvalidDataException, InvalidInputException;
    User create(User aUser) throws NullDataException, InvalidDataException, DatabaseUpdateException;
    User update(User aUser) throws NullDataException, InvalidDataException, DatabaseUpdateException;
    Long delete(Long id) throws NullDataException, InvalidDataException, DatabaseUpdateException;

}
