package com.app.assignmenttest.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Devanshu
 */
public class Preference {

    private static Preference mInstance = null;
    private Context mContext = null;
    private SharedPreferences mPreferences = null;

    private Preference(Context context) {
        mContext = context;
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static Preference getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new Preference(context.getApplicationContext());
        }
        return mInstance;
    }

    public void put(String key, String value) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key) {
        return mPreferences.getString(key, "");
    }

    public void clearDataAfterLogout() {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.clear();
        editor.commit();
    }

}
