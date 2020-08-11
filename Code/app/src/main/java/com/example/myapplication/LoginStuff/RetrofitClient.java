package com.example.myapplication.LoginStuff;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/*
Define base url of our API.
endpoint=http://ec2-54-214-218-104.us-west-2.compute.amazonaws.com/auth/login
Retrofit Singleton Client is used to handle many parallel api request.
 */
public class RetrofitClient {
    private static final String BASE_URL = "http://ec2-54-214-218-104.us-west-2.compute.amazonaws.com/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;
    //create private constructor and initialize the Retrofit object
    private RetrofitClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
}
    public static synchronized RetrofitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }
}