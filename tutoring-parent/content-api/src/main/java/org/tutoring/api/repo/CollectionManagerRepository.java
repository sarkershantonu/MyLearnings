package org.tutoring.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutoring.api.model.CollectionManager;


public interface CollectionManagerRepository extends JpaRepository<CollectionManager,Long> {
}
