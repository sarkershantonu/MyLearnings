package org.tutoring.api.emums;

public enum VideoBitRate {

    BIT_144(144),
    BIT_280(280),
    BIT_320(320),
    BIT_480(480),
    BIT_720(720),
    BIT_1080(1080),
    BIT_2096(2096);

    private  int id;

    VideoBitRate(int id) {
        this.id = id;
    }
}
