package com.example.myapplication;

import com.example.myapplication.LoginResponse;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
public interface Api {

    @FormUrlEncoded
    @POST("auth/login")
    Call<LoginResponse> userLogin(
            @Field("username") String username,
            @Field("password") String password
    );






}
