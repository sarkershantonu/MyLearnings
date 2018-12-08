package org.tutoring.api.emums;

public enum VideoFormat {
    MPEG(1),
    MP4(2),
    FLV(3),
    AVI(4);

    private  int id;

    VideoFormat(int id) {
        this.id = id;
    }
}
