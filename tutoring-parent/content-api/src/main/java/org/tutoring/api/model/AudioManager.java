package org.tutoring.api.model;

import lombok.Data;
import org.tutoring.api.emums.AudioBitRate;
import org.tutoring.api.emums.AudioFormat;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
public class AudioManager {

    @Id
    @GeneratedValue
    private Long id;
    private String filePath;
    @Enumerated(EnumType.STRING)
    private AudioFormat audioFormat;
    @Enumerated(EnumType.STRING)
    private AudioBitRate audioBitRate;
    private String audioTitle;

}

