package com.task.vasskob.testdaggersharedpref.model.repository;

import com.task.vasskob.testdaggersharedpref.utils.Prefs;

public class PrefsRepository implements Repository<String> {

    private final Prefs prefs;

    public PrefsRepository(Prefs prefs) {
        this.prefs = prefs;
    }

    @Override
    public void add(String text) {
        prefs.setSavedText(text);
    }

    @Override
    public String get() {
        return prefs.getSavedText();
    }

//    @Override
//    public List<String> query(Specification spec) {
//
//        mSpecification = (PrefsSpecification) spec;
//        mSpecification.to
//        return null;
//    }
}
