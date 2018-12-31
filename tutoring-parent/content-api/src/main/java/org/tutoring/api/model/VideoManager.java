package org.tutoring.api.model;

import lombok.Data;
import org.tutoring.api.emums.VideoBitRate;
import org.tutoring.api.emums.VideoFormat;

import javax.persistence.*;

@Entity
@Data
public class VideoManager {

    @Id
    @GeneratedValue
    private Long fileId;
    private String filePath;
    @Enumerated(EnumType.STRING)
    private VideoFormat videoFormat;
    @Enumerated(EnumType.STRING)
    private VideoBitRate videoBitRate;
    private String videoTitle;

}
