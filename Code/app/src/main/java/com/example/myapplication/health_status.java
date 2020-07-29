package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fitbitsample.fitbitdata.FitbitPref;
import com.fitbitsample.fitbitdata.FitbitSummary;
import com.fitbitsample.fitbitdata.FitbitUser;

public class health_status extends AppCompatActivity {
    private TextView getsteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_status);
        getsteps=(TextView) findViewById(R.id.get_bp);

        FitbitSummary fitbitSummary =FitbitPref.getInstance(this).getfitbitSummary();

        getsteps.setText(fitbitSummary.getSteps().toString());

    }
}
