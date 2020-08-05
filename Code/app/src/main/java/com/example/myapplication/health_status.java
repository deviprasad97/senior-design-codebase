package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.amazonS3.amazonS3main;
import com.fitbitsample.fitbitdata.FitbitPref;
import com.fitbitsample.fitbitdata.FitbitSummary;
import com.fitbitsample.fitbitdata.FitbitUser;

public class health_status extends AppCompatActivity {
    private TextView steps,avgHeartRate,caloriesBMR,caloriesout,height,weight;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_status);
        steps = findViewById(R.id.get_bp);
        avgHeartRate = findViewById(R.id.get_heartrate);
        caloriesBMR = findViewById(R.id.get_BMR);
        caloriesout = findViewById(R.id.get_calories);
        height = findViewById(R.id.get_height);
        weight = findViewById(R.id.get_weight);
        Intent intent = null;

        User user = SharedPrefManager.getInstance(this).getUser();
        LoginResponse loginResponse = SharedPrefManager.getInstance(this).getLoginResponse();
        FitbitSummary fitbitSummary =FitbitPref.getInstance(this).getfitbitSummary();
        FitbitUser fitbitUser = FitbitPref.getInstance(this).getfitbitUser();

        steps.setText(fitbitSummary.getSteps().toString());
        //avgHeartRate.setText();
        caloriesBMR.setText(fitbitSummary.getCaloriesBMR().toString());
        caloriesout.setText(fitbitSummary.getCaloriesOut().toString());
        height.setText(fitbitUser.getHeight());
        weight.setText(fitbitUser.getWeight() + "lbs");
        final String data= loginResponse.getAuth_token()+", "+fitbitSummary.getActiveScore().toString()+", "+fitbitSummary.getActivityCalories().toString()+", "+fitbitSummary.getCaloriesBMR()+", "+fitbitSummary.getCaloriesOut().toString()+", "+fitbitSummary.getTotal()+", "+fitbitSummary.getTracker()+", "+fitbitSummary.getLoggedActivities()+", "+fitbitSummary.getVeryActive()+", "+fitbitSummary.getModeratelyActive()+", "+fitbitSummary.getLightlyActive()+", "+fitbitSummary.getSedentaryActive()+", "+fitbitSummary.getFairlyActiveMinutes().toString()+", "+fitbitSummary.getSedentaryMinutes().toString()+", "+fitbitSummary.getLightlyActiveMinutes().toString()+", "+fitbitSummary.getVeryActiveMinutes().toString()+", "+fitbitSummary.getMarginalCalories().toString()+", "+fitbitSummary.getSteps().toString();

        Toast.makeText(this,data,Toast.LENGTH_LONG).show();

        Context context = getApplicationContext();
        amazonS3main az = new amazonS3main();
        try {
            az.main(context);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
