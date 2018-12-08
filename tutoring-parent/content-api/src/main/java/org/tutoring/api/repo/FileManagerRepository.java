package org.tutoring.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutoring.api.model.FileManager;

public interface FileManagerRepository extends JpaRepository<FileManager,Long> {
}
