package org.tutoring.api.model.contents;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
@Data
public class DocumentInfo {

    @Id
    @GeneratedValue
    private String id;
    private String authority;
    private String mimeType;
    private String displayName;
    private LocalDate lastModified;
    private String summary;
    private Long size;
    @OneToOne
    private RawFile path;
}
