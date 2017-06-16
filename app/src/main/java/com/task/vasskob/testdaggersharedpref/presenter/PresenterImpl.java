package com.task.vasskob.testdaggersharedpref.presenter;

import com.task.vasskob.testdaggersharedpref.model.repository.PrefsRepository;
import com.task.vasskob.testdaggersharedpref.model.repository.Repository;
import com.task.vasskob.testdaggersharedpref.view.MyView;

import static com.task.vasskob.testdaggersharedpref.Constants.LOAD_ERROR;
import static com.task.vasskob.testdaggersharedpref.Constants.LOAD_SUCCESS;
import static com.task.vasskob.testdaggersharedpref.Constants.SAVE_ERROR;
import static com.task.vasskob.testdaggersharedpref.Constants.SAVE_SUCCESS;

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
            myView.showToast(LOAD_SUCCESS);
        }

        @Override
        public void onError(String error) {
            myView.showToast(LOAD_ERROR);
        }
    };

    private final Repository.OnSavedListener saveListener = new PrefsRepository.OnSavedListener() {
        @Override
        public void onSaved() {
            myView.showToast(SAVE_SUCCESS);
        }

        @Override
        public void onError(String message) {
            myView.showToast(SAVE_ERROR);
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
