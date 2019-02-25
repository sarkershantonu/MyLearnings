package org.tutoring.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tutoring.api.model.AudioManager;
@Repository
public interface AudioManagerRepository extends JpaRepository<AudioManager,Long> {
}
