package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tutoring.api.model.User;
import org.tutoring.api.repo.UserRepository;

import java.util.Collection;

public class UserServiceBean implements UserService {

    @Autowired
    private UserRepository UserRepository;

    @Override
    public Collection<User> viewAll() {
        return UserRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return null;
    }

    @Override
    public User create(User aUser) {
        return null;
    }

    @Override
    public User update(User aUser) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }
}
