package org.tutoring.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutoring.api.model.CourseManager;

public interface CourseManagerRepository extends JpaRepository<CourseManager,Long> {
}
