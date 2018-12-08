package org.tutoring.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutoring.api.model.ImageManager;

public interface ImageManagerRepository extends JpaRepository<ImageManager,Long> {
}
