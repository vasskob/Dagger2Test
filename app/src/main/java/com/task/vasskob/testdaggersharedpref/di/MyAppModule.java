package com.task.vasskob.testdaggersharedpref.di;

import android.app.Application;
import android.content.Context;

import com.task.vasskob.testdaggersharedpref.model.repository.PrefsRepository;
import com.task.vasskob.testdaggersharedpref.presenter.PresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
    PrefsRepository providePrefsRepository(Context context) {
        return new PrefsRepository(context);
    }

    @Provides
    @Singleton
    PresenterImpl providePresenter() {
        return new PresenterImpl();
    }
}
