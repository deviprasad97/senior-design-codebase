package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Welcomescreen extends AppCompatActivity {

    private TextView Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // On create start
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomescreen);
        Button getStartedButton = findViewById(R.id.button_get_started);
        Login = findViewById(R.id.loginbutton);
        final GetStartedListDialogFragment getStartedListDialogFragment =
                GetStartedListDialogFragment.newInstance();
        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getStartedListDialogFragment.show(getSupportFragmentManager(),
                        "get_started_dialog_fragment");
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Welcomescreen.this, com.example.myapplication.LoginStuff.Login.class));
            }
        });

        // On create end

    }

    //If the User is already logged in, take use straight to homescreen
    @Override
    protected void onStart() {
        super.onStart();
        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(this, homescreen.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}
