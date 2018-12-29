package org.tutoring.api.model;

import org.tutoring.api.emums.DocumentFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class DocumentManager {

    @Id
    @GeneratedValue
    private Long fileId;
    private String filePath;
    @Enumerated(EnumType.STRING)
    private DocumentFormat documentFormat;
    private String documentTitle;
    private String documentAuthor;

    public boolean isValid() {

        if (fileId == null || fileId <= 0
                || filePath == null || filePath.isEmpty()
                || documentFormat == null
                || documentTitle == null || documentTitle.isEmpty()
                || documentAuthor == null || documentAuthor.isEmpty()) {
            return false;
        }
        return true;
    }

}
