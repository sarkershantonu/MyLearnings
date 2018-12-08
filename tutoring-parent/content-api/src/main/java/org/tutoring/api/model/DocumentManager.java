package org.tutoring.api.model;

import org.tutoring.api.emums.DocumentFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class DocumentManager {

    @Id
    @GeneratedValue
    private long fileId;
    private String filePath;
    @Enumerated(EnumType.STRING)
    private DocumentFormat documentFormat;
    private String documentTitle;
    private String documentAuthor;

}
