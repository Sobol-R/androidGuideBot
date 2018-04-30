package com.guide.androidguidebot;

import java.io.Serializable;

/**
 * Created by User on 30.04.2018.
 */

public class TestPlaces implements Serializable {
    public TestPlaces(String placeId, double latitude, double longitude) {
        this.placeId = placeId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    String placeId;
    double latitude;
    double longitude;
}
