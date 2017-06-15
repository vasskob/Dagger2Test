package com.task.vasskob.testdaggersharedpref.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs  {
    private static final String KEY = "savedText";
    private static final String PREFS_NAME = "prefs";
    private static Prefs instance;
    private final SharedPreferences sharedPreferences;

    private Prefs(Context context) {

        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static Prefs with(Context context) {

        if (instance == null) {
            instance = new Prefs(context);
        }
        return instance;
    }

    public void setSavedText(String text) {

        sharedPreferences
                .edit()
                .putString(KEY, text)
                .apply();
    }

    public String getSavedText() {
        return sharedPreferences.getString(KEY, "error");
    }
}
