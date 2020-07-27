package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class health_status extends AppCompatActivity {
    private TextView getsteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_status);
        getsteps=(TextView) findViewById(R.id.get_bp);

    }
}
