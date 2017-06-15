package com.task.vasskob.testdaggersharedpref.model.repository;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsRepository implements Repository<String> {

    private static final String PREFS_NAME = "prefs";
    private static final String KEY_SAVED_TEXT = "KEY_SAVED_TEXT";

    public static final String DEFAULT_SAVED_TEXT = "DEFAULT";

    private final SharedPreferences prefs;

    public PrefsRepository(Context context) {
        this.prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void add(String text) {
        prefs
                .edit()
                .putString(KEY_SAVED_TEXT, text)
                .apply();
    }

    @Override
    public String get() {
        return prefs.getString(KEY_SAVED_TEXT, DEFAULT_SAVED_TEXT);
    }

}
