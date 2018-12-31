package org.tutoring.api.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class CourseManager {
    @Id
    @GeneratedValue
    private Long id;
    private Long courseId;
    private Long userId;
    private Long roleId;
}
