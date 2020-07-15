package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    private static final String SHARED_PREF_NAME = "my_shared_preff";

    private static SharedPrefManager mInstance;
    private Context mCtx;

    private SharedPrefManager(Context mCtx) {
        this.mCtx = mCtx;
    }
    //save single instance
    public static synchronized SharedPrefManager getInstance(Context mCtx) {
        if (mInstance == null) //object is not yet created
        {
            mInstance = new SharedPrefManager(mCtx);
        }
        return mInstance;
    }
    public void saveUser(User user) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("address", user.getAddress());
        editor.putString("bio", user.getBio());
        editor.putString("city", user.getCity());
        editor.putString("email", user.getEmail());
        editor.putString("fname", user.getFname());
        editor.putString("gender", user.getGender());
        editor.putString("lname", user.getLname());
        editor.putString("password", user.getPassword());
        editor.putString("phone", user.getPhone());
        editor.putBoolean("is_admin", user.isIs_admin());
        editor.putString("state", user.getState());
        editor.putString("uname", user.getUname());
        editor.putString("zipcode", user.getZipcode());
        editor.putBoolean("is_email_verified", user.isIs_email_verified());
        editor.putBoolean("profile_pic", user.isProfile_pic());
        editor.putInt("user_id", user.getUser_id());
        editor.apply();

    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("user_id", -1) != -1;
    }

    public User getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getString("address", null),
                sharedPreferences.getString("bio", null),
                sharedPreferences.getString("city", null),
                sharedPreferences.getString("email", null),
                sharedPreferences.getString("fname", null),
                sharedPreferences.getString("gender", null),
                sharedPreferences.getString("lname", null),
                sharedPreferences.getString("password", null),
                sharedPreferences.getString("phone", null),
                sharedPreferences.getString("state", null),
                sharedPreferences.getString("uname", null),
                sharedPreferences.getString("zipcode", null),
                sharedPreferences.getBoolean("is_admin",false),
                sharedPreferences.getBoolean("is_email_verified", true),
                sharedPreferences.getBoolean("profile_pic", true),
                sharedPreferences.getInt("user_id", -1)




        );
    }
    public void clear() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}




