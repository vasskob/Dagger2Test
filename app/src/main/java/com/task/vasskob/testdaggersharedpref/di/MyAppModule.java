package com.task.vasskob.testdaggersharedpref.di;

import android.app.Application;
import android.content.Context;

import com.task.vasskob.testdaggersharedpref.model.repository.PrefsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MyAppModule {
    private Application application;

    public MyAppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    PrefsRepository providePrefsRepository(Context context) {
        return new PrefsRepository(context);
    }
}
