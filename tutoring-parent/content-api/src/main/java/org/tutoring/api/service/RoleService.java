package org.tutoring.api.service;

import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.Role;

import java.util.Collection;

public interface RoleService {

    Collection<Role> viewAll();
    Role findOne(Long id) throws NullDataException, InvalidDataException;
    Role create(Role aRole) throws NullDataException, InvalidDataException;
    Role update(Role aRole) throws InvalidDataException, NullDataException;
    Long delete(Long id);

}
