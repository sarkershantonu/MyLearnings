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
}
