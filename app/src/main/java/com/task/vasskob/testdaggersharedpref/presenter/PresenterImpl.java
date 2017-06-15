package com.task.vasskob.testdaggersharedpref.presenter;

import com.task.vasskob.testdaggersharedpref.MyApplication;
import com.task.vasskob.testdaggersharedpref.model.repository.PrefsRepository;
import com.task.vasskob.testdaggersharedpref.view.MyView;

import javax.inject.Inject;

import static com.task.vasskob.testdaggersharedpref.Constants.DEFAULT_SAVED_TEXT;
import static com.task.vasskob.testdaggersharedpref.Constants.LOAD_ERROR;
import static com.task.vasskob.testdaggersharedpref.Constants.LOAD_SUCCESS;
import static com.task.vasskob.testdaggersharedpref.Constants.SAVE_ERROR;
import static com.task.vasskob.testdaggersharedpref.Constants.SAVE_SUCCESS;

public class PresenterImpl implements Presenter, PrefsRepository.MyListener {

    @Inject
    public PrefsRepository repository;
    private MyView myView;

    public PresenterImpl() {
        MyApplication.getInstance().getMyAppComponent().inject(this);
        repository.setListener(this);
    }

    @Override
    public void saveText(String text) {
        repository.add(text);
    }

    @Override
    public void loadText() {
        String text = repository.get();
        if (text.equals(DEFAULT_SAVED_TEXT)) {
            myView.showToast(LOAD_ERROR);
        } else {
            myView.showSavedText(text);
            myView.showToast(LOAD_SUCCESS);
        }
    }

    @Override
    public void attachView(MyView view) {
        myView = view;
    }

    @Override
    public void detachView() {
        myView = null;
    }

    @Override
    public void onSuccess() {
        myView.showToast(SAVE_SUCCESS);
    }

    @Override
    public void onError() {
        myView.showToast(SAVE_ERROR);
    }
}
