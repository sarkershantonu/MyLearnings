package org.tutoring.api.emums;

import com.sun.imageio.plugins.jpeg.JPEG;

public enum ImageFormat {

    JPG(1),
    JPEG(2),
    PNG(3),
    GIF(4);

    private int format;

    ImageFormat(int format){
        this.format = format;
    }

}
