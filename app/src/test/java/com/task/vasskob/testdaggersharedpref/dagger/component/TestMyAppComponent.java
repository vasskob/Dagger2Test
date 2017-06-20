package com.task.vasskob.testdaggersharedpref.dagger.component;

import com.task.vasskob.testdaggersharedpref.dagger.module.TestActivityModule;
import com.task.vasskob.testdaggersharedpref.di.MyAppComponent;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Subcomponent;

@Singleton
@Component(modules = TestActivityModule.class)
public interface TestMyAppComponent extends MyAppComponent {
    //  TestActivityComponent plusTestActivityComponent(ActivityModule module);

    TestActivityComponent.Builder testActivityComponentBuilder();

    @Subcomponent.Builder
    interface Builder {
        TestMyAppComponent.Builder activityModule(TestActivityModule activityModule);

        TestMyAppComponent build();
    }
}