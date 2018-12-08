package org.tutoring.api.service;

import org.tutoring.api.model.User;

import java.util.Collection;

public interface UserService {

    Collection<User> viewAll();
    User findOne(Long id);
    User create(User aUser);
    User update(User aUser);
    Long delete(Long id);

}
