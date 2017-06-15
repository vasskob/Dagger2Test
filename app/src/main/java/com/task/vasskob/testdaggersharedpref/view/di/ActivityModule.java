package com.task.vasskob.testdaggersharedpref.view.di;

import com.task.vasskob.testdaggersharedpref.presenter.PresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @Provides
    @ActivityScope
    PresenterImpl providePresenter() {
        return new PresenterImpl();
    }
}
