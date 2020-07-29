package com.fitbitsample.fitbitdata;

import android.content.Context;
import android.content.SharedPreferences;

public class FitbitPref {

    private static final String SHARED_PREF_NAME = "my_shared_pref";

    private static FitbitPref fInstance;
    private Context fCtx;

    private FitbitPref(Context fCtx) {
        this.fCtx = fCtx;
    }
    //save single instance
    public static synchronized FitbitPref getInstance(Context fCtx) {
        if (fInstance == null) //object is not yet created
        {
            fInstance = new FitbitPref(fCtx);
        }
        return fInstance;
    }
    public void savefitbitdata(FitbitUser fitbitUser){

        SharedPreferences sharedPreferences = fCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("dateOfBirth",fitbitUser.getDateOfBirth());
        editor.putString("fullName",fitbitUser.getFullName());
        editor.putString("gender",fitbitUser.getGender());
        editor.putString("height",fitbitUser.getHeight());
        editor.putString("weight",fitbitUser.getWeight());
        editor.apply();
    }

    public FitbitUser getfitbitUser(){
        SharedPreferences sharedPreferences = fCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new FitbitUser(
                sharedPreferences.getString("dateOfBirth",null),
                sharedPreferences.getString("fullName",null),
                sharedPreferences.getString("gender",null),
                sharedPreferences.getString("height",null),
                sharedPreferences.getString("weight",null)
        );
    }

    public void saveFitbitSummary(FitbitSummary fitbitSummary) {

        SharedPreferences sharedPreferences = fCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("activeScore",fitbitSummary.getActiveScore());
        editor.putInt("activityCalories",fitbitSummary.getActivityCalories());
        editor.putInt("caloriesBMR",fitbitSummary.getCaloriesBMR());
        editor.putInt("caloriesOut",fitbitSummary.getCaloriesOut());
        editor.putInt("fairlyActiveMinutes",fitbitSummary.getFairlyActiveMinutes());
        editor.putInt("lightlyActiveMinutes",fitbitSummary.getLightlyActiveMinutes());
        editor.putInt("marginalCalories",fitbitSummary.getMarginalCalories());
        editor.putInt("sedentaryMinutes",fitbitSummary.getSedentaryMinutes());
        editor.putInt("steps",fitbitSummary.getSteps());
        editor.putInt("veryActiveMinutes",fitbitSummary.getVeryActiveMinutes());
        editor.apply();
    }
    public FitbitSummary getfitbitSummary() {
        SharedPreferences sharedPreferences = fCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new FitbitSummary(
                sharedPreferences.getInt("activeScore",0),
                sharedPreferences.getInt("activityCalories",0),
                sharedPreferences.getInt("caloriesBMR",0),
                sharedPreferences.getInt("caloriesOut",0),
                sharedPreferences.getInt("fairlyActiveMinutes",0),
                sharedPreferences.getInt("lightlyActiveMinutes",0),
                sharedPreferences.getInt("marginalCalories",0),
                sharedPreferences.getInt("sedentaryMinutes",0),
                sharedPreferences.getInt("steps",0),
                sharedPreferences.getInt("veryActiveMinutes",0)

        );
    }

}
