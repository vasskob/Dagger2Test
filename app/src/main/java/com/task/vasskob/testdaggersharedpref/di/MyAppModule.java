package com.task.vasskob.testdaggersharedpref.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.task.vasskob.testdaggersharedpref.Constants.PREFS_NAME;

@Module
public class MyAppModule {
    private final Application application;

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
    SharedPreferences provideSharedPrefs(Context context) {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }
}
