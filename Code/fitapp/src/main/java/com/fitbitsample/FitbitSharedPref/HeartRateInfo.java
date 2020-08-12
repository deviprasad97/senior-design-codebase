package com.fitbitsample.FitbitSharedPref;

/*
    Saves the summarize data from fitbit website,
    each time GetHrModel is triggered the data
    gets saved in the preference and updates the local cache
   As of now its hit and trial on the data received from
   fitbit so please look into that
 */
public class HeartRateInfo {
    private String heartdata;

    public HeartRateInfo(String heartdata) {
        this.heartdata = heartdata;
    }

    public String getHeartdata() {
        return heartdata;
    }

    public void setHeartdata(String heartdata) {
        this.heartdata = heartdata;
    }
}
