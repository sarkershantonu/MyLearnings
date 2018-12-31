package org.tutoring.api.model;

import lombok.Data;
import org.tutoring.api.emums.ImageFormat;

import javax.persistence.*;

@Data
@Entity
public class ImageManager {

    @Id
    @GeneratedValue
    private Long fileId;
    private String filePath;
    @Enumerated(EnumType.STRING)
    private ImageFormat imageFormat;
    private int imageDpi;

}
