package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.LoginStuff.LoginResponse;
import com.example.myapplication.LoginStuff.User;
import com.example.myapplication.amazonS3.amazonS3main;
import com.fitbitsample.FitbitSharedPref.FitbitPref;
import com.fitbitsample.FitbitSharedPref.FitbitSummary;
import com.fitbitsample.FitbitSharedPref.FitbitUser;

/*
This activity is for displaying health data that is retrieved from fitbit integrating module app.
In fitapp module, under java->com.fitbitsample->fitbitdata->FitbitPref, SharedPreference is created that
saves Fitbit user's profile information and health summary. We just call those object and display in our app.
 */
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
        //ActivityInfo activityInfo = PaperDB.getInstance().get().read(PaperConstants.ACTIVITY_INFO,null);

        //Getting data from the SharedPrefManger and FitbitPref
        User user = SharedPrefManager.getInstance(this).getUser();
        LoginResponse loginResponse = SharedPrefManager.getInstance(this).getLoginResponse();
        FitbitSummary fitbitSummary =FitbitPref.getInstance(this).getfitbitSummary();
        FitbitUser fitbitUser = FitbitPref.getInstance(this).getfitbitUser();

        /*
        Since we have the datas from just above process we can just display them in the specific field.
         */
        steps.setText(fitbitSummary.getSteps().toString());
        //avgHeartRate.setText();
        caloriesBMR.setText(fitbitSummary.getCaloriesBMR().toString());
        caloriesout.setText(fitbitSummary.getCaloriesOut().toString());
        height.setText(fitbitUser.getHeight());
        weight.setText(fitbitUser.getWeight() + "lbs");
        final String data= loginResponse.getAuth_token()+", "+fitbitSummary.getActiveScore().toString()+", "+fitbitSummary.getActivityCalories().toString()+", "+fitbitSummary.getCaloriesBMR()+", "+fitbitSummary.getCaloriesOut().toString()+", "+fitbitSummary.getTotal()+", "+fitbitSummary.getTracker()+", "+fitbitSummary.getLoggedActivities()+", "+fitbitSummary.getVeryActive()+", "+fitbitSummary.getModeratelyActive()+", "+fitbitSummary.getLightlyActive()+", "+fitbitSummary.getSedentaryActive()+", "+fitbitSummary.getFairlyActiveMinutes().toString()+", "+fitbitSummary.getSedentaryMinutes().toString()+", "+fitbitSummary.getLightlyActiveMinutes().toString()+", "+fitbitSummary.getVeryActiveMinutes().toString()+", "+fitbitSummary.getMarginalCalories().toString()+", "+fitbitSummary.getSteps().toString();
        /*
        We are just toasting the data that we have recieved just for confirmation, this can be removed when
        the app is final.
         */
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
