package com.fitbitsample.receiver;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.fitbitsample.constant.PrefConstants;
import com.fitbitsample.activity.MainActivity;
import com.fitbitsample.preference.AppPreference;


public class AccessTokenReceiver extends AppCompatActivity {

    String data;
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onNewIntent(Intent intent) {
        data = intent.getDataString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onNewIntent(getIntent());
        if (data.contains("code=")) {
            String code = data.substring(data.indexOf("code=") + 5).replace("#_=_", "");
            Log.i("TAG code: ", code);
            AppPreference.getInstance().putString(PrefConstants.CODE, code);
            AppPreference.getInstance().putBoolean(PrefConstants.IS_CODE_RECEIVED, true);
        }
        Intent intent = new Intent(AccessTokenReceiver.this, MainActivity.class);
        startActivity(intent);
    }
}
