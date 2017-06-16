package com.task.vasskob.testdaggersharedpref.presenter;

import com.task.vasskob.testdaggersharedpref.model.repository.PrefsRepository;
import com.task.vasskob.testdaggersharedpref.model.repository.Repository;
import com.task.vasskob.testdaggersharedpref.view.MyView;

public class PresenterImpl implements Presenter {

    private PrefsRepository repository;
    private MyView myView;

    public PresenterImpl(PrefsRepository repository) {
        this.repository = repository;
    }

    private final Repository.OnLoadListener<String> loadListener = new PrefsRepository.OnLoadListener<String>() {
        @Override
        public void onLoaded(String data) {
            myView.showSavedText(data);
            myView.showLoadSuccessToast();
        }

        @Override
        public void onError(String error) {
            myView.showLoadErrorToast();
        }
    };

    private final Repository.OnSavedListener saveListener = new PrefsRepository.OnSavedListener() {
        @Override
        public void onSaved() {
            myView.showSaveSuccessToast();
        }

        @Override
        public void onError(String message) {
            myView.showSaveErrorToast();
        }
    };

    @Override
    public void saveText(String text) {
        repository.add(text, saveListener);
    }

    @Override
    public void loadText() {
        repository.get(loadListener);
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
