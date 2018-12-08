package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tutoring.api.model.Role;
import org.tutoring.api.repo.RoleRepository;

import java.util.Collection;

public class RoleServiceBean implements RoleService {

    @Autowired
    private RoleRepository RoleRepository;

    @Override
    public Collection<Role> viewAll() {
        return RoleRepository.findAll();
    }

    @Override
    public Role findOne(Long id) {
        return null;
    }

    @Override
    public Role create(Role aRole) {
        return null;
    }

    @Override
    public Role update(Role aRole) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }
}
