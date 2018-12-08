package org.tutoring.api.emums;

public enum CollectionFormat {

    VIDEO("video"),
    AUDIO("audio"),
    DOCUMENT("document");

    private String id;

    CollectionFormat(String id) {
        this.id = id;
    }
}
