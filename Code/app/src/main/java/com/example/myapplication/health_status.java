package com.example.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

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

        FitbitSummary fitbitSummary =FitbitPref.getInstance(this).getfitbitSummary();
        FitbitUser fitbitUser = FitbitPref.getInstance(this).getfitbitUser();

        steps.setText(fitbitSummary.getSteps().toString());
        //avgHeartRate.setText();
        caloriesBMR.setText(fitbitSummary.getCaloriesBMR().toString());
        caloriesout.setText(fitbitSummary.getCaloriesOut().toString());
        height.setText(fitbitUser.getHeight());
        weight.setText(fitbitUser.getWeight() + "lbs");

        amazonS3main az = new amazonS3main();
        try {
            az.main();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
