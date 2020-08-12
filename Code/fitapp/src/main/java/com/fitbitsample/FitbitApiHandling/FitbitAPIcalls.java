package com.fitbitsample.FitbitApiHandling;

import com.fitbitsample.FitbitDataType.HeartRate;
import com.fitbitsample.FitbitDataType.OAuthResponse;
import com.fitbitsample.FitbitDataType.ActivityInfo;
import com.fitbitsample.FitbitDataType.UserInfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface FitbitAPIcalls {

    @FormUrlEncoded
    @POST("oauth2/token?")
    Call<OAuthResponse> getAccessToken(@Field("client_id") String client_id, @Field("grant_type") String grantType,
                                       @Field("redirect_uri") String redirectUri, @Field("code") String code);

    @GET("1/user/{userId}/profile.json")
    Call<UserInfo> getUserProfile(@Path("userId") String userId);

    @GET("1/user/{userId}/activities/date/{date}.json")
    Call<ActivityInfo> getActivitiesByDate(@Path("userId") String userId, @Path("date") String date);

    @GET("1/user/{userId}/activities/heart/date/{date}/{period}.json")
    Call<HeartRate> getHrByRange(@Path("userId") String userId, @Path("date") String date, @Path("period") String period);

}
