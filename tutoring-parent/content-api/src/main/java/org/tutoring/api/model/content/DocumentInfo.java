package org.tutoring.api.model.content;

import java.time.LocalDate;

public class DocumentInfo {
    private String authority;
    private String id;
    private String mimeType;
    private String displayName;
    private LocalDate lastModified;
    private String summary;
    private Long size;
    private RawFile path;
}
