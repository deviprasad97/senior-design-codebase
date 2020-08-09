package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class FitBitActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fit_bit);

        Intent intent = null;
        try {
            intent = new Intent(this,
                    Class.forName("com.fitbitsample.activity.MainActivity"));
            startActivity(intent);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

}