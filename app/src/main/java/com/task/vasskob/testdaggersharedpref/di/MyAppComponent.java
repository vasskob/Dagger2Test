package com.task.vasskob.testdaggersharedpref.di;


import com.task.vasskob.testdaggersharedpref.view.di.ActivityComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MyAppModule.class})
public interface MyAppComponent {
    ActivityComponent.Builder activityComponentBuilder();
}
