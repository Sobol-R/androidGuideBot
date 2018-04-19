package com.guide.androidguidebot;

import java.io.Serializable;

/**
 * Created by rosti on 18.04.2018.
 */

public class VisitedPlaces implements Serializable {
    public VisitedPlaces(String title, String imgPath, float latitude, float longitude) {
        this.title = title;
        this.imgPath = imgPath;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    String title;
    String imgPath;
    float latitude;
    float longitude;
}
