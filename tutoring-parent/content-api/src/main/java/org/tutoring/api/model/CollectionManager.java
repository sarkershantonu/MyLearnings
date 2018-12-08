package org.tutoring.api.model;

import org.tutoring.api.emums.CollectionFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class CollectionManager {

    @Id
    @GeneratedValue
    private long fileId;
    private String filePath;
    @Enumerated(EnumType.STRING)
    private CollectionFormat collectionFormat;


}