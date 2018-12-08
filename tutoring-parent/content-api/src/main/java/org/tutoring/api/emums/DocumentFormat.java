package org.tutoring.api.emums;

public enum DocumentFormat {
    PDF(1),
    DOC(2),
    DOCS(3),
    PPT(4),
    PPTX(5),
    TXT(6);

    private int id;

    DocumentFormat(int id) {
        this.id = id;
    }
}
