package org.tutoring.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutoring.api.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
