package org.tutoring.api.model;

import lombok.Data;
import org.tutoring.api.emums.DocumentFormat;

import javax.persistence.*;

@Entity
@Data
public class DocumentManager {

    @Id
    @GeneratedValue
    private Long fileId;
    private String filePath;
    @Enumerated(EnumType.STRING)
    private DocumentFormat documentFormat;
    private String documentTitle;
    private String documentAuthor;

}
