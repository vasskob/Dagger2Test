package com.task.vasskob.testdaggersharedpref.model.repository;

import android.content.Context;
import android.content.SharedPreferences;

import static com.task.vasskob.testdaggersharedpref.Constants.DEFAULT_SAVED_TEXT;

public class PrefsRepository implements Repository<String> {

    private static final String PREFS_NAME = "prefs";
    private static final String KEY_SAVED_TEXT = "KEY_SAVED_TEXT";


    private final SharedPreferences prefs;
    private MyListener listener;

    public PrefsRepository(Context context) {
        this.prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void setListener(MyListener listener) {
        this.listener = listener;
    }

    @Override
    public void add(String text) {
        prefs
                .edit()
                .putString(KEY_SAVED_TEXT, text)
                .apply();

        if (!get().equals(DEFAULT_SAVED_TEXT)) {
            listener.onSuccess();
        } else {
            listener.onError();
        }
    }

    @Override
    public String get() {
        return prefs.getString(KEY_SAVED_TEXT, DEFAULT_SAVED_TEXT);
    }

    public interface MyListener {
        void onSuccess();

        void onError();
    }
}
