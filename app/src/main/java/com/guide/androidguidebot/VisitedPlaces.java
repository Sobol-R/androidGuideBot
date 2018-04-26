package com.guide.androidguidebot;

import java.io.Serializable;

/**
 * Created by rosti on 18.04.2018.
 */

public class VisitedPlaces implements Serializable {
    public VisitedPlaces(String title, String imgPath, String description) {
        this.title = title;
        this.imgPath = imgPath;
        this.description = description;
    }

    String title;
    String imgPath;
    String description;
}
