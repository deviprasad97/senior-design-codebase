package com.fitbitsample.FitbitDataType;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/*
    Creating a viewing adapter class for parsing gson file of heartrate received from Fitbit API call
 */

import java.util.List;

public class HeartRate {

    @SerializedName("activities-heart")
    @Expose
    private List<ActivitiesHeart> activitiesHeart = null;

    public List<ActivitiesHeart> getActivitiesHeart() {
        return activitiesHeart;
    }

    public void setActivitiesHeart(List<ActivitiesHeart> activitiesHeart) {
        this.activitiesHeart = activitiesHeart;
    }

    @Override
    public String toString() {
        return "HeartRate{" +
                "activitiesHeart=" + activitiesHeart +
                '}';
    }
}
