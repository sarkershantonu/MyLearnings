package org.tutoring.api.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Content {
    @Id
    @GeneratedValue
    private Long id;
    private Long courseId;
    private Long fileManagerId;
    private String title;
    private String description;
    private String path;
}
