package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class SplashScreen extends AppCompatActivity {
    Thread myThread;
    SharedPreferences sharedPreferences;
    String MY_PREFERENCES = "MY_PREFERENCES";
    String EMAIL_ID = "email_id";
    String USER_NAME = "user_name";
    String PASSWORD = "password";
    String IS_LOGGED = "IS_LOGGED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sharedPreferences = SplashScreen.this.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);

        myThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1800);
                    if (sharedPreferences.getString(IS_LOGGED, "0").equals("1")) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                        finish();
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();

    }
}
