package org.tutoring.api.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class History {

    @Id
    @GeneratedValue
    private Long id;

    private Long contentId;
    private String courseStatus;
    private String contentStatus;

}
