package com.task.vasskob.testdaggersharedpref.model.repository;

interface Repository<T> {
    void add(T item);
    T get();
}
