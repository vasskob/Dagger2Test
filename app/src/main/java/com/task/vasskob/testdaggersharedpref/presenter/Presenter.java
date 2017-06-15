package com.task.vasskob.testdaggersharedpref.presenter;

import com.task.vasskob.testdaggersharedpref.view.MyView;

interface Presenter {
    void attachView(MyView view);
    void detachView();

    void saveText(String text);
    void loadText();
}
