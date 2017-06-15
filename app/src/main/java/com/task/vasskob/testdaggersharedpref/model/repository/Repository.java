package com.task.vasskob.testdaggersharedpref.model.repository;

interface Repository<T> {
    void add(T item);
//    void update(T item);
//    void delete(T item);
//    List<T> query(Specification specification);
    T get();
}
