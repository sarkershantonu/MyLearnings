package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.Role;
import org.tutoring.api.repo.RoleRepository;

import java.util.Collection;

public class RoleServiceBean implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Collection<Role> viewAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findOne(Long id) throws NullDataException, InvalidDataException {

        if (null == id){
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id <=0 ){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return roleRepository.getOne(id);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Role create(Role aRole) throws NullDataException, InvalidDataException {

        if (null == aRole){
            throw new NullDataException(APIMessages.DATA_NULL);
        }
        if (!aRole.isValid()){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return roleRepository.save(aRole);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Role update(Role aRole) throws InvalidDataException, NullDataException {

        if (null == aRole){
            throw new NullDataException(APIMessages.DATA_NULL);
        }
        if (!aRole.isValid()){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return roleRepository.save(aRole);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Long delete(Long id) {
        return null;
    }
}
