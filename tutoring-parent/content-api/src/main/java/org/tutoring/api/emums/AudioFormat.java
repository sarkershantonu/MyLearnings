package org.tutoring.api.emums;

public enum AudioFormat {

    MP3("mp3"),
    AMR("amr"),
    WMA("wma"),
    WAV("wav");

    private String id;

    AudioFormat(String id){
        this.id = id;
    }
}
