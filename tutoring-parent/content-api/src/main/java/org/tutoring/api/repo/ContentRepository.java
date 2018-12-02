package org.tutoring.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutoring.api.model.Content;

public interface ContentRepository extends JpaRepository<Content,Long> {
}
