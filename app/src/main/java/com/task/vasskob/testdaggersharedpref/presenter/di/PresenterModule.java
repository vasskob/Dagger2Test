package com.task.vasskob.testdaggersharedpref.presenter.di;

import android.content.Context;

import com.task.vasskob.testdaggersharedpref.model.repository.PrefsRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    @PresenterScope
    PrefsRepository providePrefsRepository(Context context) {
        return new PrefsRepository(context);
    }
}
