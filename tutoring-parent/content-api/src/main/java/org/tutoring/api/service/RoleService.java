package org.tutoring.api.service;

import org.tutoring.api.model.Role;

import java.util.Collection;

public interface RoleService {

    Collection<Role> viewAll();
    Role findOne(Long id);
    Role create(Role aRole);
    Role update(Role aRole);
    Long delete(Long id);

}
