package org.tutoring.api.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Role {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String role;

    public boolean isValid() {

        if (id== null || id <= 0
                || role == null || role.isEmpty()) {
            return false;
        }
        return true;
    }

}
