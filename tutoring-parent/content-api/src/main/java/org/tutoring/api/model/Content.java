package org.tutoring.api.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Content {
    @Id
    @GeneratedValue
    private Long contentId;
    private Long courseId;
    private Long fileManagerId;
    private String title;
    private String description;
    private String path;
}