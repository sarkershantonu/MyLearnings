package org.tutoring.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutoring.api.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
