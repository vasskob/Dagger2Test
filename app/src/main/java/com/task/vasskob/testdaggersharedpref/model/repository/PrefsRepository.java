package com.task.vasskob.testdaggersharedpref.model.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;

public class PrefsRepository implements Repository<String> {

    private static final String PREFS_NAME = "prefs";
    private static final String KEY_SAVED_TEXT = "KEY_SAVED_TEXT";
    private static final long DELAY_MS = 1000;


    private final SharedPreferences prefs;
    private MyListener listener;

    private Handler  mHandler = new Handler(Looper.myLooper());

    public PrefsRepository(Context context) {
        this.prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void setListener(MyListener listener) {
        this.listener = listener;
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
                listener.onSuccess();
            }
        }, DELAY_MS);
    }

    @Override
    public void get(OnLoadListener listener) {
        // TODO: 15/06/17 implement
//        return prefs.getString(KEY_SAVED_TEXT, DEFAULT_SAVED_TEXT);
    }

    public interface MyListener {
        void onSuccess();

        void onError();
    }
}
