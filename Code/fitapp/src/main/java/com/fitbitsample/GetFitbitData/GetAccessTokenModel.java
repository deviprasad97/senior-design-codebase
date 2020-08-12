package com.fitbitsample.GetFitbitData;

import android.content.Context;

import com.fitbitsample.FitbitActivity.AppConstants;
import com.fitbitsample.FitbitActivity.PrefConstants;
import com.fitbitsample.PaperConstants;
import com.fitbitsample.PaperDB;
import com.fitbitsample.FitbitApiHandling.NetworkListener;
import com.fitbitsample.FitbitApiHandling.RestCall;
import com.fitbitsample.FitbitSharedPref.AppPreference;
import com.fitbitsample.FragmentTraceManager.Trace;
import com.fitbitsample.FitbitDataType.OAuthResponse;

import java.util.Map;

import static com.fitbitsample.FitbitActivity.AppConstants.REDIRECT_URI;
import static com.fitbitsample.FitbitActivity.PrefConstants.CODE;
import static com.fitbitsample.FitbitActivity.PrefConstants.GRANT_TYPE;

public class GetAccessTokenModel extends BaseAndroidViewModel<Integer, OAuthResponse, Void, GetAccessTokenModel> {

    public GetAccessTokenModel(int errorCode) {
        super(false, errorCode);
    }

    @Override
    public GetAccessTokenModel run(final Context context, final Void aVoid) {
        String code = AppPreference.getInstance().getString(CODE);
        restCall = new RestCall<>(context, true);
        restCall.execute(fitbitAPIcalls.getAccessToken(AppConstants.CLIENT_ID, GRANT_TYPE, REDIRECT_URI, code), 3, new NetworkListener<OAuthResponse>() {
            @Override
            public void success(OAuthResponse response) {
                if (response != null) {
                    PaperDB.getInstance().write(PaperConstants.OAUTH_RESPONSE, response);
                    AppPreference.getInstance().putBoolean(PrefConstants.HAVE_AUTHORIZATION, true);
                    AppPreference.getInstance().putString(PrefConstants.TOKEN_TYPE, response.getTokenType());
                    AppPreference.getInstance().putString(PrefConstants.REFRESH_TOKEN, response.getTokenType());
                    AppPreference.getInstance().putString(PrefConstants.FULL_AUTHORIZATION, response.getTokenType() + " " + response.getAccessToken());
                    AppPreference.getInstance().putString(PrefConstants.USER_ID, response.getUserId());
                    Trace.i("Response Access token:" + response.toString());
                    data.postValue(0);
                } else {
                    data.postValue(errorCode);
                }
            }

            @Override
            public void headers(Map<String, String> header) {

            }

            @Override
            public void failure() {
                data.postValue(errorCode);
            }
        });
        return this;
    }

}
