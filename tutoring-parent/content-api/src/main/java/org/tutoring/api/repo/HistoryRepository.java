package org.tutoring.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutoring.api.model.History;

public interface HistoryRepository extends JpaRepository<History,Long> {
}
