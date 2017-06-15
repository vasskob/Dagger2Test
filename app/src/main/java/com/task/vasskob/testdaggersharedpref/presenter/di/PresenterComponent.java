package com.task.vasskob.testdaggersharedpref.presenter.di;

import com.task.vasskob.testdaggersharedpref.presenter.PresenterImpl;

import dagger.Subcomponent;

@PresenterScope
@Subcomponent(modules = PresenterModule.class)
public interface PresenterComponent {

    @Subcomponent.Builder
    interface Builder {
        PresenterComponent.Builder presenterModule(PresenterModule presenterModule);
        PresenterComponent build();
    }
    void inject(PresenterImpl presenter);
}
