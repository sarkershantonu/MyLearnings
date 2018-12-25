package org.tutoring.api.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class CourseManager {
    @Id
    @GeneratedValue
    private Long id;
    private Long courseId;
    private Long userId;
    private Long roleId;

    public boolean isValid() {

        if (id == null || id <= 0
                || courseId == null || courseId <= 0
                || userId == null || userId <= 0
                || roleId == null || roleId <= 0
                ) {
            return false;
        }

        return true;
    }
}
