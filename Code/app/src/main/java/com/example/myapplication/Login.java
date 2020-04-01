package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.AccessController;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button getStartedButton = findViewById(R.id.button_get_started);
        final GetStartedListDialogFragment getStartedListDialogFragment =
                GetStartedListDialogFragment.newInstance();
        Button mobileUser = findViewById(R.id.mobile_user);
        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getStartedListDialogFragment.show(getSupportFragmentManager(),
                        "add_photo_dialog_fragment");
            }
        });


    }
}
