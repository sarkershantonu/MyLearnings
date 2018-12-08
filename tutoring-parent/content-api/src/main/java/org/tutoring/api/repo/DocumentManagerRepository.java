package org.tutoring.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutoring.api.model.DocumentManager;

public interface DocumentManagerRepository extends JpaRepository<DocumentManager,Long> {
}
