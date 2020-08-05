package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.RetrofitClient;
import com.example.myapplication.LoginResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;

import java.io.UnsupportedEncodingException;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private TextView Register;
    private Button login;
    private EditText  editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.register).setOnClickListener(this);
        findViewById(R.id.button_sign_in).setOnClickListener(this);
        editTextEmail= findViewById(R.id.comp_username);
        editTextPassword= findViewById(R.id.customer_pass);
        /*Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,UserRegistration.class));
            }
        });
        */

    }
    private void userLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }
/*
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

 */

        if (password.isEmpty()) {
            editTextPassword.setError("Password required");
            editTextPassword.requestFocus();
            return;
        }
        Call<LoginResponse> call = RetrofitClient
                .getInstance().getApi().userLogin(email, password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                   if(response.isSuccessful()) {
                       LoginResponse loginResponse = response.body();

                       if (loginResponse.getStatus().equals("success")) {
                           Toast.makeText(Login.this, loginResponse.getAuth_token(), Toast.LENGTH_LONG).show();
                           SharedPrefManager.getInstance(Login.this)
                                   .saveUser(loginResponse.getUser());
                           SharedPrefManager.getInstance(Login.this).saveLoginResponse(loginResponse);
                           Intent intent = new Intent(Login.this, homescreen.class);
                           intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                           startActivity(intent);
                       }
                       else {
                           Toast.makeText(Login.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                       }

                   }

                   else
                   {
                       Toast.makeText(Login.this, "User does not exist.", Toast.LENGTH_LONG).show();
                   }


            }



            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
        @Override
        public void onClick (View v){
            switch (v.getId()) {
                case R.id.button_sign_in:
                    userLogin();
                    break;

            }
        }
    }
