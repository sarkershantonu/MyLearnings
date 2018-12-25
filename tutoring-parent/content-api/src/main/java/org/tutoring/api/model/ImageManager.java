package org.tutoring.api.model;

import org.tutoring.api.emums.ImageFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ImageManager {

    @Id
    @GeneratedValue
    private Long fileId;
    private String filePath;
    @Enumerated(EnumType.STRING)
    private ImageFormat imageFormat;
    private int imageDpi;

    public boolean isValid() {

        if (fileId == null || fileId <= 0
                || filePath == null || filePath.isEmpty()
                || imageFormat == null) {
            return false;
        }
        return true;
    }
}
