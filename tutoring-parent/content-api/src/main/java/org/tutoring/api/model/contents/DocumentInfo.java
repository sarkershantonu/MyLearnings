package org.tutoring.api.model.contents;

import java.time.LocalDate;

public class DocumentInfo {

    private String id;
    private String authority;
    private String mimeType;
    private String displayName;
    private LocalDate lastModified;
    private String summary;
    private Long size;
    private RawFile path;
}
