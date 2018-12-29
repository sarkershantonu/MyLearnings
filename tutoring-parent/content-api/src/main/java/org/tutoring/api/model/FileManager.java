package org.tutoring.api.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class FileManager {

    @Id
    @GeneratedValue
    private Long fileManagerId;
    private Long  fileId;

    public boolean isValid() {

        if (fileManagerId == null || fileManagerId <= 0
                || fileId == null || fileId <= 0) {
            return false;
        }
        return true;
    }
}
