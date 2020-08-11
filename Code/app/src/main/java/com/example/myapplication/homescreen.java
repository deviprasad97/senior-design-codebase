package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.LoginStuff.Login;

public class homescreen extends AppCompatActivity {

    private ImageView home,you,program,settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        home= findViewById(R.id.selected);
        you= findViewById(R.id.you);
        program= findViewById(R.id.program);
        //settings=(ImageView) findViewById(R.id.settings);
        //Takes to health_status page when big round red button is pressed from homescreen
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homescreen.this, health_status.class));
            }
        });
        //Takes to setting page when you button is pressed from homescreen
        you.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homescreen.this, SettingsPage.class));
            }
        });
        //Takes to program page when Program button is pressed from homescreen
        program.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homescreen.this, select_program.class));
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(!SharedPrefManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(this, Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }


}
