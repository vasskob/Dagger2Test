package com.task.vasskob.testdaggersharedpref;

import android.app.Application;

import com.task.vasskob.testdaggersharedpref.presenter.di.PresenterComponent;
import com.task.vasskob.testdaggersharedpref.presenter.di.PresenterModule;
import com.task.vasskob.testdaggersharedpref.view.di.ActivityComponent;
import com.task.vasskob.testdaggersharedpref.view.di.ActivityModule;
import com.task.vasskob.testdaggersharedpref.di.DaggerMyAppComponent;
import com.task.vasskob.testdaggersharedpref.di.MyAppComponent;
import com.task.vasskob.testdaggersharedpref.di.MyAppModule;


public class MyApplication extends Application {

    private MyAppComponent myAppComponent;
    private PresenterComponent presenterComponent;
    private ActivityComponent activityComponent;

    private static MyApplication instance;
    public static MyApplication getInstance() {
        return instance;
    }

    public MyAppComponent getMyAppComponent() {
        return myAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        myAppComponent = initDagger(this).build();
    }

    private DaggerMyAppComponent.Builder initDagger(MyApplication myApplication) {
        return DaggerMyAppComponent.builder()
                .myAppModule(new MyAppModule(myApplication));
    }

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = getMyAppComponent()
                    .activityComponentBuilder()
                    .activityModule(new ActivityModule())
                    .build();
        }
        return activityComponent;
    }

    public PresenterComponent getPresenterComponent() {
        if (presenterComponent == null) {
            presenterComponent = getActivityComponent()
                    .presenterComponentBuilder()
                    .presenterModule(new PresenterModule())
                    .build();
        }
        return presenterComponent;
    }
}
