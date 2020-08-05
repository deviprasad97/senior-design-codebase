package com.fitbitsample.viewmodel;

import android.content.Context;
import android.util.Log;

import com.fitbitsample.constant.PrefConstants;
import com.fitbitsample.db.paper.PaperConstants;
import com.fitbitsample.db.paper.PaperDB;
import com.fitbitsample.fitbitdata.FitbitPref;
import com.fitbitsample.fitbitdata.FitbitSummary;
import com.fitbitsample.network.NetworkError;
import com.fitbitsample.network.NetworkListener;
import com.fitbitsample.network.RestCall;
import com.fitbitsample.preference.AppPreference;
import com.fitbitsample.util.Trace;
import com.fitbitsample.viewmodel.response.OAuthResponse;
import com.fitbitsample.viewmodel.response.Steps.ActivityInfo;
import com.fitbitsample.viewmodel.response.Steps.Distance;
import com.fitbitsample.viewmodel.response.sleep.SleepInfo;

import java.util.List;
import java.util.Map;

public class GetActivityModel extends BaseAndroidViewModel<Integer, ActivityInfo, String, GetActivityModel> {
    private Integer activeScore, activityCalories, caloriesBMR, caloriesOut, fairlyActiveMinutes, lightlyActiveMinutes, marginalCalories, sedentaryMinutes, steps, veryActiveMinutes;
    private String distance, total, tracker, loggedActivities, veryActive, moderatelyActive, lightlyActive, sedentaryActive;
    public GetActivityModel(int errorCode) {
        super(true, errorCode);
    }

    @Override
    public GetActivityModel run(final Context context, final String date) {
        restCall = new RestCall<>(context, true);
        restCall.execute(restServices.getActivitiesByDate(AppPreference.getInstance().getString(PrefConstants.USER_ID), date), new NetworkListener<ActivityInfo>() {
            @Override
            public void success(ActivityInfo activityInfo) {
                if (activityInfo != null) {
                    Log.i("Activity_info:", activityInfo.toString());
                    activeScore = activityInfo.getSummary().getActiveScore();
                    activityCalories = activityInfo.getSummary().getActivityCalories();
                    caloriesBMR = activityInfo.getSummary().getCaloriesBMR();
                    caloriesOut = activityInfo.getSummary().getCaloriesOut();
                    fairlyActiveMinutes = activityInfo.getSummary().getFairlyActiveMinutes();
                    lightlyActiveMinutes = activityInfo.getSummary().getLightlyActiveMinutes();
                    marginalCalories = activityInfo.getSummary().getMarginalCalories();
                    sedentaryMinutes = activityInfo.getSummary().getSedentaryMinutes();
                    steps = activityInfo.getSummary().getSteps();
                    veryActiveMinutes = activityInfo.getSummary().getVeryActiveMinutes();
                    List<Distance> distances = activityInfo.getSummary().getDistances();
                    for(Distance d: distances)
                    {
                        if(d.getActivity().equals("total"))
                        {
                            total = d.getDistance().toString();
                        }
                        else if(d.getActivity().equals("tracker"))
                        {
                            tracker = d.getDistance().toString();
                        }
                        else if(d.getActivity().equals("loggedActivities"))
                        {
                            loggedActivities = d.getDistance().toString();
                        }
                        else if(d.getActivity().equals("veryActive"))
                        {
                            veryActive = d.getDistance().toString();
                        }
                        else if(d.getActivity().equals("moderatelyActive"))
                        {
                            moderatelyActive = d.getDistance().toString();
                        }
                        else if(d.getActivity().equals("lightlyActive"))
                        {
                            lightlyActive = d.getDistance().toString();
                        }
                        else if(d.getActivity().equals("sedentaryActive"))
                        {
                            sedentaryActive = d.getDistance().toString();
                        }
                    }

                    FitbitSummary fitbitSummary = new FitbitSummary(activeScore, activityCalories, caloriesBMR, caloriesOut, fairlyActiveMinutes, lightlyActiveMinutes, marginalCalories, sedentaryMinutes, steps, veryActiveMinutes, total, tracker, loggedActivities, veryActive, moderatelyActive, lightlyActive, sedentaryActive);
                    FitbitPref.getInstance(context).saveFitbitSummary(fitbitSummary);


                    PaperDB.getInstance().write(PaperConstants.ACTIVITY_INFO, activityInfo);
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

