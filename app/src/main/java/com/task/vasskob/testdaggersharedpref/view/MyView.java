package com.task.vasskob.testdaggersharedpref.view;

public interface MyView {
    void showLoadSuccessToast();

    void showLoadErrorToast();

    void showSaveSuccessToast();

    void showSaveErrorToast();
    void showSavedText(String text);
}
