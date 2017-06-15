package com.task.vasskob.testdaggersharedpref.presenter;

import com.task.vasskob.testdaggersharedpref.model.repository.PrefsRepository;
import com.task.vasskob.testdaggersharedpref.utils.Prefs;
import com.task.vasskob.testdaggersharedpref.view.MyView;

public class PresenterImpl implements Presenter {

    private final PrefsRepository repository;
    private MyView myView;

    public PresenterImpl(Prefs prefs) {
        repository = new PrefsRepository(prefs);
    }

    @Override
    public void saveText(String text) {
        repository.add(text);
        myView.showSaveSuccessToast();
    }

    @Override
    public void loadText() {
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
