package com.task.vasskob.testdaggersharedpref.presenter;

import android.content.Context;

import com.task.vasskob.testdaggersharedpref.model.repository.PrefsRepository;
import com.task.vasskob.testdaggersharedpref.view.MyView;

public class PresenterImpl implements Presenter {

    private final PrefsRepository repository;
    private MyView myView;

    public PresenterImpl(Context context) {
        repository = new PrefsRepository(context);
    }

    @Override
    public void saveText(String text) {
        // TODO: 15/06/17 implement fake async loading with loader
        repository.add(text);
        myView.showSaveSuccessToast();
    }

    @Override
    public void loadText() {
        // TODO: 15/06/17 implement fake async loading with loader
        String text = repository.get();
        myView.showSavedText(text);
        myView.showLoadSuccessToast();
    }

    @Override
    public void attachView(MyView view) {
        myView = view;
    }

    @Override
    public void detachView() {
        myView = null;
    }

}
