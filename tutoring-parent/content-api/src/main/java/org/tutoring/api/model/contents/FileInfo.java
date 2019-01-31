package org.tutoring.api.model.contents;

import lombok.Data;
import org.tutoring.api.emums.FileTypes;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.io.File;

@Entity
@Data
public class FileInfo {
    @Id
    private String name;
    private String description;
    private String extention;
    @Enumerated(EnumType.STRING)
    private FileTypes fileType;
    private Long size;
    private File file;
}
