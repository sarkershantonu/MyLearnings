package org.tutoring.api.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Content {
    @Id
    @GeneratedValue
    private Long contentId;
    private Long courseId;
    private Long fileManagerId;
    private String title;
    private String description;
    private String path;

    public boolean isValid() {

        if (contentId == null || contentId <= 0
                || courseId == null || courseId <= 0
                || fileManagerId == null || fileManagerId <= 0
                || title == null || title.isEmpty()
                || path == null || path.isEmpty()) {
            return false;
        }

        return true;
    }
}