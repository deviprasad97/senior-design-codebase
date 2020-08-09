package com.fitbitsample.viewmodel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.fitbitsample.constant.PrefConstants;
import com.fitbitsample.db.paper.PaperConstants;
import com.fitbitsample.db.paper.PaperDB;
import com.fitbitsample.fitbitdata.FitbitPref;
import com.fitbitsample.fitbitdata.HeartRateInfo;
import com.fitbitsample.network.NetworkError;
import com.fitbitsample.network.NetworkListener;
import com.fitbitsample.network.RestCall;
import com.fitbitsample.preference.AppPreference;
import com.fitbitsample.viewmodel.response.ActivitiesHeart;
import com.fitbitsample.viewmodel.response.HeartRate;
import com.fitbitsample.viewmodel.response.Value;

import java.util.List;
import java.util.Map;

public class GetHrModel extends BaseAndroidViewModel<Integer, HeartRate, String[], GetHrModel> {
    private Integer averageheartrate;

    public GetHrModel(int errorCode) {
        super(true, errorCode);
    }

    @Override
    public GetHrModel run(final Context context, final String... params) {
        restCall = new RestCall<>(context, true);
        restCall.execute(restServices.getHrByRange(AppPreference.getInstance().getString(PrefConstants.USER_ID), params[0], params[1]), new NetworkListener<HeartRate>() {
            @Override
            public void success(HeartRate heartRate) {
                if (heartRate != null) {
                    Log.i("Hr:", heartRate.toString());
                    FitbitPref.getInstance(context).saveHeartData(new HeartRateInfo(heartRate.toString().replaceAll("[\\n\\t ]", "").replace(",","|")));
                    //Value value = heartRate.getActivitiesHeart().contains(Value);
                    //Toast.makeText(context,averageheartrate,Toast.LENGTH_LONG).show();
                    PaperDB.getInstance().write(PaperConstants.HEART_RATE, heartRate);
                    data.postValue(0);
                } else {
                    //Toast.makeText(context,"fk",Toast.LENGTH_LONG).show();
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
