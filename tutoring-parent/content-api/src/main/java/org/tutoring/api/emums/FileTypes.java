package org.tutoring.api.emums;

public enum FileTypes {

    TXT("txt"),
    VIDEO("video"),
    IMAGE("image"),
    AUDIO("audio"),
    DOC("doc"),
    DOCX("docx"),
    PDF("pdf"),
    HTML("html");
    private String id;

    FileTypes(String id) {
        this.id = id;
    }
}
