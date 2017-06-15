package com.task.vasskob.testdaggersharedpref.presenter;

import com.task.vasskob.testdaggersharedpref.view.MyView;

public interface Presenter {
    void saveText(String text);
    void loadText();
    void attachView(MyView view);
    void detachView();
}
