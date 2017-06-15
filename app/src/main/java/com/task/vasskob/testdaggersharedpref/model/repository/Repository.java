package com.task.vasskob.testdaggersharedpref.model.repository;

public interface Repository<T> {
    void add(T item, OnSavedListener listener);
    void get(OnLoadListener<T> listener);

    public interface OnSavedListener {
        void onSaved();
        void onError(String message);
    }

    public interface OnLoadListener<T> {
        void onLoaded(T data);
        void onError(String message);
    }
}
