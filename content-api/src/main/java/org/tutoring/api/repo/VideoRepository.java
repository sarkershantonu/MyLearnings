package org.tutoring.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tutoring.api.model.VideoFile;

/**
 * Created by SSarker on 10/27/2018.
 */
@Repository
public interface VideoRepository extends JpaRepository<VideoFile,Long> {
}
