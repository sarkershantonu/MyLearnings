package org.tutoring.api.service;

import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.User;

import java.util.Collection;

public interface UserService {

    Collection<User> viewAll();
    User findOne(Long id) throws NullDataException, InvalidDataException;
    User create(User aUser) throws NullDataException, InvalidDataException;
    User update(User aUser) throws NullDataException, InvalidDataException;
    Long delete(Long id) throws NullDataException, InvalidDataException;

}
