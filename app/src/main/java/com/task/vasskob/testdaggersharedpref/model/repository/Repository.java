package com.task.vasskob.testdaggersharedpref.model.repository;

public interface Repository<T> {
    void add(T item, OnSavedListener listener);
    void get(OnLoadListener<T> listener);

    interface OnSavedListener {
        void onSaved();
        @SuppressWarnings("unused")
        void onError(String message);
    }

    interface OnLoadListener<T> {
        void onLoaded(T data);
        @SuppressWarnings("unused")
        void onError(String message);
    }
}
