package org.tutoring.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutoring.api.model.AudioManager;

public interface AudioManagerRepository extends JpaRepository<AudioManager,Long> {
}
