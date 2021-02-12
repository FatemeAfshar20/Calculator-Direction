package com.org.calculator.database;

import androidx.lifecycle.LiveData;

import java.util.List;

import io.reactivex.Completable;

public interface IRepository<T> {
    LiveData<T> get(int id);
    LiveData<List<T>> getList();
    void insert(T t);
    void delete(T t);
    void update(T t);
}
