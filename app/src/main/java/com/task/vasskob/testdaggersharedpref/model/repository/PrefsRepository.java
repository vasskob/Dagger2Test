package com.task.vasskob.testdaggersharedpref.model.repository;

import android.content.SharedPreferences;
import android.os.Handler;

import javax.inject.Inject;

import static com.task.vasskob.testdaggersharedpref.Constants.DEFAULT_SAVED_TEXT;

public class PrefsRepository implements Repository<String> {

    private static final String KEY_SAVED_TEXT = "KEY_SAVED_TEXT";
    private static final long DELAY_MS = 1000;

    @Inject
    SharedPreferences prefs;

    private final Handler mHandler = new Handler();

    @Inject
    PrefsRepository() {
    }

    @Override
    public void add(String text, final OnSavedListener listener) {
        prefs
                .edit()
                .putString(KEY_SAVED_TEXT, text)
                .apply();

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onSaved();
            }
        }, DELAY_MS);
    }

    @Override
    public void get(final OnLoadListener<String> listener) {
        final String result = prefs.getString(KEY_SAVED_TEXT, DEFAULT_SAVED_TEXT);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onLoaded(result);
            }
        }, DELAY_MS);
    }
}
