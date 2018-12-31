package org.tutoring.api.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class History {

    @Id
    @GeneratedValue
    private Long id;
    private Long contentId;
    private String courseStatus;
    private String contentStatus;

    public boolean isValid() {

        if (id == null || id <= 0
                || contentId == null || contentId <= 0
                || courseStatus == null || courseStatus.isEmpty()
                || contentStatus == null || contentStatus.isEmpty()) {
            return false;
        }
        return true;
    }

}
