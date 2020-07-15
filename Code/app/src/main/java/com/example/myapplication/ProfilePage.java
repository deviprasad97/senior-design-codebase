package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfilePage extends AppCompatActivity {

    private TextView fullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        fullname=findViewById(R.id.fullname);
        User user=SharedPrefManager.getInstance(this).getUser();
        fullname.setText(user.getFname()+" "+user.getLname());

    }
}
