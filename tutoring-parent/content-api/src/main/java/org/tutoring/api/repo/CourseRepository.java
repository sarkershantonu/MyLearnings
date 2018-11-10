package org.tutoring.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutoring.api.model.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
