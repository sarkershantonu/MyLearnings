package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.User;
import org.tutoring.api.repo.UserRepository;

import java.util.Collection;

@Transactional(propagation = Propagation.SUPPORTS)
public class UserServiceBean implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Collection<User> viewAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) throws NullDataException, InvalidDataException {
        if (null == id){
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id <=0 ){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return userRepository.getOne(id);


    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User create(User aUser) throws NullDataException, InvalidDataException {

        if (null == aUser){
            throw new NullDataException(APIMessages.DATA_NULL);
        }
        if (!aUser.isValid()){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return userRepository.save(aUser);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User update(User aUser) throws NullDataException, InvalidDataException {


        if (null == aUser){
            throw new NullDataException(APIMessages.DATA_NULL);
        }
        if (!aUser.isValid()){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return userRepository.save(aUser);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Long delete(Long id) throws NullDataException, InvalidDataException {

        if (id == null){
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id <=0 ){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }

        userRepository.deleteById(id);
        return id;
    }
}
