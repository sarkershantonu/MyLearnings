package org.tutoring.api.model.contents;

import org.tutoring.api.emums.FileTypes;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.File;

@Entity
public class FileInfo {
    private String name;
    private String description;
    private String extention;
    @Enumerated(EnumType.STRING)
    private FileTypes fileType;
    private Long size;
    private File file;
}
