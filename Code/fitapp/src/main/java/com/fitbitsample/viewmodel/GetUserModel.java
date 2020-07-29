package com.fitbitsample.viewmodel;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.fitbitsample.activity.MainActivity;
import com.fitbitsample.constant.PrefConstants;
import com.fitbitsample.db.paper.PaperConstants;
import com.fitbitsample.db.paper.PaperDB;
import com.fitbitsample.fitbitdata.FitbitPref;
import com.fitbitsample.fitbitdata.FitbitUser;
import com.fitbitsample.network.NetworkError;
import com.fitbitsample.network.NetworkListener;
import com.fitbitsample.network.RestCall;
import com.fitbitsample.preference.AppPreference;
import com.fitbitsample.util.Trace;
import com.fitbitsample.viewmodel.response.Device;
import com.fitbitsample.viewmodel.response.OAuthResponse;
import com.fitbitsample.viewmodel.response.User;
import com.fitbitsample.viewmodel.response.UserInfo;

import java.util.List;
import java.util.Map;

public class GetUserModel extends BaseAndroidViewModel<Integer, UserInfo, Void, GetUserModel> {
    private String dateOfBirth, fullName, gender, height, weight;
    public GetUserModel(int errorCode) {
        super(true, errorCode);
    }

    @Override
    public GetUserModel run(final Context context, Void aVoid) {

        restCall = new RestCall<>(context, true);
        restCall.execute(restServices.getUserProfile(AppPreference.getInstance().getString(PrefConstants.USER_ID)), new NetworkListener<UserInfo>() {
            @Override
            public void success(UserInfo userInfo) {
                if (userInfo != null) {
                    Log.i("User Profile:", userInfo.toString());
                    dateOfBirth = userInfo.getUser().getDateOfBirth();
                    fullName = userInfo.getUser().getFullName();
                    gender = userInfo.getUser().getGender();
                    height = userInfo.getUser().getHeight().toString();
                    weight = userInfo.getUser().getWeight().toString();
                    FitbitUser fitbitUser = new FitbitUser(dateOfBirth,fullName,gender,height,weight);
                    FitbitPref.getInstance(context).savefitbitdata(fitbitUser);
                    PaperDB.getInstance().write(PaperConstants.PROFILE, userInfo);
                    data.postValue(0);
                } else {
                    data.postValue(errorCode);
                }
            }

            @Override
            public void headers(Map<String, String> header) {

            }

            @Override
            public void fail(int code, List<NetworkError> networkErrors) {
                if (code == 404) {
                    data.postValue(0);
                } else {
                    data.postValue(errorCode);
                }
            }

            @Override
            public void failure() {
                data.postValue(errorCode);
            }
        });
        return this;
    }
}
