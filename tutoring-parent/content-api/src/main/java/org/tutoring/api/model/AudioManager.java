package org.tutoring.api.model;

import org.tutoring.api.emums.AudioBitRate;
import org.tutoring.api.emums.AudioFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

public class AudioManager {

    @Id
    @GeneratedValue
    private long fileId;
    private  String filePath;
    @Enumerated(EnumType.STRING)
    private AudioFormat audioFormat;
    @Enumerated(EnumType.STRING)
    private AudioBitRate audioBitRate;
    private String audioTitle;

    //Do we really need this
    //AudioPlayerList
}

