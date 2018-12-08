package org.tutoring.api.model;

import org.tutoring.api.emums.VideoBitRate;
import org.tutoring.api.emums.VideoFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class VideoManager {

    @Id
    @GeneratedValue
    private long fileId;
    private String filePath;
    @Enumerated(EnumType.STRING)
    private VideoFormat videoFormat;
    @Enumerated(EnumType.STRING)
    private VideoBitRate videoBitRate;
    private String videoTitle;

    // Need to think about this
    // private videoPlayerList videoPlayerList;



}
