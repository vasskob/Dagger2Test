package com.task.vasskob.testdaggersharedpref;

import android.app.Application;

import com.task.vasskob.testdaggersharedpref.di.DaggerMyAppComponent;
import com.task.vasskob.testdaggersharedpref.di.MyAppComponent;
import com.task.vasskob.testdaggersharedpref.di.MyAppModule;


public class MyApplication extends Application {

    private static MyApplication instance;
    public static MyApplication getInstance() {
        return instance;
    }

    private MyAppComponent myAppComponent;
    public MyAppComponent getMyAppComponent() {
        return myAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        myAppComponent = initDagger(this);
    }

    private MyAppComponent initDagger(MyApplication myApplication) {
        return DaggerMyAppComponent.builder()
                .myAppModule(new MyAppModule(myApplication))
                .build();
    }
}
