package com.task.vasskob.testdaggersharedpref.dagger;

import android.app.Application;

import com.task.vasskob.testdaggersharedpref.dagger.component.TestActivityComponent;


public class TestMyApplication extends Application {

    public TestActivityComponent createFakeComponent() {
//        return DaggerTestActivityComponent.builder()
//                .testActivityComponentBuilder
//                .testActivityModule(new TestActivityModule())
//                .build();
        return null;
    }
}
