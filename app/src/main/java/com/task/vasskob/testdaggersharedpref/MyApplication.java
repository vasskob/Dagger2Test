package com.task.vasskob.testdaggersharedpref;

import android.app.Application;

import com.task.vasskob.testdaggersharedpref.di.DaggerMyAppComponent;
import com.task.vasskob.testdaggersharedpref.di.MyAppComponent;
import com.task.vasskob.testdaggersharedpref.di.MyAppModule;
import com.task.vasskob.testdaggersharedpref.view.di.ActivityComponent;
import com.task.vasskob.testdaggersharedpref.view.di.ActivityModule;


public class MyApplication extends Application {

    private MyAppComponent myAppComponent;
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

    public void clearActivityComponent() {
        activityComponent = null;
    }
}
