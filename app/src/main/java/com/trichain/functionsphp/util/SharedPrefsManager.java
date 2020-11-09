package com.trichain.functionsphp.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SharedPrefsManager {
    private static final String KEY_IS_USER_REGISTERED = "key_is_user_registered";
    private static final String KEY_IS_ENROLLED = "key_has_enrolled_to_leaderboard";
    private static final String KEY_HAS_ACCEPTED_TERMS = "key_has_accepted_terms";
    private static final String KEY_NOTIFICATION_DATE = "key_notification_date";
    private static SharedPreferences sharedPreferences;
    private static SharedPrefsManager mInstance;
    private final String SHARED_PREFS_NAME = "kenya_sihami";
    private static final String TAG = "SharedPrefsManager";

    private SharedPrefsManager(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized SharedPrefsManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefsManager(context);
        }
        return mInstance;
    }


    /*Check if user is registered*/
    public boolean isRegistered() {
        return sharedPreferences.getBoolean(KEY_IS_USER_REGISTERED, false);
    }

    /*check if user as enrolled to leaderboard*/
    public boolean hasEnrolledToLeaderBoard() {
        return sharedPreferences.getBoolean(KEY_IS_ENROLLED, false);
    }

    /*enroll to leaderboard*/
    public void enrollUserToLeaderBoard() {
        sharedPreferences.edit().putBoolean(KEY_IS_ENROLLED, true).apply();
    }

    /*unenroll from leaderboard*/
    public void unEnrollUserToLeaderBoard() {
        sharedPreferences.edit().putBoolean(KEY_IS_ENROLLED, false).apply();
    }





    /*Check if user has accepted terms*/
    public boolean hasAcceptedTerms() {
        return sharedPreferences.getBoolean(KEY_HAS_ACCEPTED_TERMS, false);
    }

    /*Set user has accepted terms*/
    public void setAcceptedTerms(boolean accepted) {
        sharedPreferences.edit()
                .putBoolean(KEY_HAS_ACCEPTED_TERMS, accepted)
                .apply();
    }

    /*Check if has shown notification today*/
    public boolean hasShownNotification() {
        Calendar c = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        String dateNow = format.format(c.getTime());
        return sharedPreferences.getString(KEY_NOTIFICATION_DATE, "dfsds").contentEquals(dateNow);
    }

    /*Set notification date*/
    public void setNotificationShown() {
        Calendar c = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        String dateNow = format.format(c.getTime());
        sharedPreferences.edit()
                .putString(KEY_NOTIFICATION_DATE, dateNow)
                .apply();
    }
}


