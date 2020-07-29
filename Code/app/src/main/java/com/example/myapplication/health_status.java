package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fitbitsample.fitbitdata.FitbitPref;
import com.fitbitsample.fitbitdata.FitbitSummary;
import com.fitbitsample.fitbitdata.FitbitUser;

public class health_status extends AppCompatActivity {
    private TextView steps,avgHeartRate,caloriesBMR,caloriesout,height,weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_status);
        steps = (TextView) findViewById(R.id.get_bp);
        avgHeartRate = (TextView) findViewById(R.id.get_heartrate);
        caloriesBMR = (TextView) findViewById(R.id.get_BMR);
        caloriesout = (TextView) findViewById(R.id.get_calories);
        height = (TextView) findViewById(R.id.get_height);
        weight = (TextView) findViewById(R.id.get_weight);

        FitbitSummary fitbitSummary =FitbitPref.getInstance(this).getfitbitSummary();
        FitbitUser fitbitUser = FitbitPref.getInstance(this).getfitbitUser();

        steps.setText(fitbitSummary.getSteps().toString());
        //avgHeartRate.setText();
        caloriesBMR.setText(fitbitSummary.getCaloriesBMR().toString());
        caloriesout.setText(fitbitSummary.getCaloriesOut().toString());
        height.setText(fitbitUser.getHeight());
        weight.setText(fitbitUser.getWeight() + "lbs");


    }
}
