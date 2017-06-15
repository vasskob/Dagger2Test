package com.task.vasskob.testdaggersharedpref.model.repository;

import android.content.SharedPreferences;

public class PrefsRepository implements Repository<String> {

    private static final String KEY = "savedText";
    private final SharedPreferences prefs;

    public PrefsRepository(SharedPreferences prefs) {
        this.prefs = prefs;
    }

    @Override
    public void add(String text) {
        prefs
                .edit()
                .putString(KEY, text)
                .apply();
    }

    @Override
    public String get() {
        return prefs.getString(KEY, "error");
    }

//    @Override
//    public List<String> query(Specification spec) {
//
//        mSpecification = (PrefsSpecification) spec;
//        mSpecification.to
//        return null;
//    }
}
