package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.model.User;
import org.tutoring.api.repo.UserRepository;

import java.util.Collection;

@Transactional(propagation = Propagation.SUPPORTS)
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
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User create(User aUser) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User update(User aUser) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Long delete(Long id) {
        return null;
    }
}
