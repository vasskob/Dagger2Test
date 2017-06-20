package com.task.vasskob.testdaggersharedpref.dagger.component;

import com.task.vasskob.testdaggersharedpref.TestPresenterVsDagger;
import com.task.vasskob.testdaggersharedpref.dagger.module.TestActivityModule;
import com.task.vasskob.testdaggersharedpref.view.di.ActivityComponent;
import com.task.vasskob.testdaggersharedpref.view.di.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent
public interface TestActivityComponent extends ActivityComponent {

    @Subcomponent.Builder
    interface Builder {
        TestActivityComponent.Builder testActivityModule(TestActivityModule activityModule);

        TestActivityComponent build();
    }

    void inject(TestPresenterVsDagger test);
    // public void inject(TestPresenterImpl presenter);
}
