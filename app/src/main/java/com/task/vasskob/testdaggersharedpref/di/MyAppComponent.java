package com.task.vasskob.testdaggersharedpref.di;


import com.task.vasskob.testdaggersharedpref.presenter.PresenterImpl;
import com.task.vasskob.testdaggersharedpref.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = {MyAppModule.class})
public interface MyAppComponent {
    void inject (MainActivity activity);
    void inject (PresenterImpl presenter);
}
