package com.task.vasskob.testdaggersharedpref.view.di;

import com.task.vasskob.testdaggersharedpref.presenter.di.PresenterComponent;
import com.task.vasskob.testdaggersharedpref.view.MainActivity;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    PresenterComponent.Builder presenterComponentBuilder();

    @Subcomponent.Builder
    interface Builder {
        ActivityComponent.Builder activityModule(ActivityModule activityModule);
        ActivityComponent build();
    }

    void inject(MainActivity activity);
}
