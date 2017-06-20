package com.task.vasskob.testdaggersharedpref.dagger.module;

import com.task.vasskob.testdaggersharedpref.model.repository.PrefsRepository;
import com.task.vasskob.testdaggersharedpref.presenter.PresenterImpl;
import com.task.vasskob.testdaggersharedpref.view.di.ActivityModule;
import com.task.vasskob.testdaggersharedpref.view.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class TestActivityModule extends ActivityModule {

    @Provides
    @ActivityScope
    PresenterImpl providePresenter(PrefsRepository repository) {
        return new PresenterImpl(repository);
    }

}

