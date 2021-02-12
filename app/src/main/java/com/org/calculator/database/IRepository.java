package com.org.calculator.database;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface IRepository<T> {
    Flowable<T> get(int id);
    Flowable<List<T>> getList();
    Completable insert(T t);
    Completable delete(T t);
    Completable update(T t);
}
