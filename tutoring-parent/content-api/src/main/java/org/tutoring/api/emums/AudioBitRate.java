package org.tutoring.api.emums;

public enum AudioBitRate {

    BIT_56(56),
    BIT_128(128),
    BIT_356(356);

    private int rate;

    AudioBitRate(int rate) {
        this.rate = rate;
    }
}
