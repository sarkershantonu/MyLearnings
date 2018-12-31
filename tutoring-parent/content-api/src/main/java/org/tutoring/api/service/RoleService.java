package org.tutoring.api.service;

import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.Role;

import java.util.Collection;

public interface RoleService {

    Collection<Role> viewAll() throws InvalidDataException;
    Role findOne(Long id) throws NullDataException, InvalidDataException, InvalidInputException;
    Role create(Role aRole) throws NullDataException, InvalidDataException, DatabaseUpdateException;
    Role update(Role aRole) throws InvalidDataException, NullDataException, DatabaseUpdateException;
    Long delete(Long id) throws DatabaseUpdateException, NullDataException;

}
