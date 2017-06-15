package com.task.vasskob.testdaggersharedpref.model.repository;

interface Repository<T> {
    void add(T item, OnSavedListener listener);
    void get(OnLoadListener<T> listener);

    public interface OnSavedListener {
        void onSuccess();
        void onError(String message);
    }

    public interface OnLoadListener<T> {
        void onLoaded(T data);
        void onError(String message);
    }
}
