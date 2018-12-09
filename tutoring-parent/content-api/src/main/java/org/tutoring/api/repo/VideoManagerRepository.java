package org.tutoring.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutoring.api.model.VideoManager;

public interface VideoManagerRepository extends JpaRepository<VideoManager,Long> {
}
