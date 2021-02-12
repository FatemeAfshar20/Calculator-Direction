package com.org.calculator.database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.org.calculator.database.dao.DirectionDao;
import com.org.calculator.model.DirectionModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.rxjava3.core.Flowable;

public class CalculateRepository implements IRepository<DirectionModel>{
    private static CalculateRepository sInstance;
    private DirectionDao mDao;
    private CalculatorDatabase mDatabase;

    private CalculateRepository(Context context) {
        mDatabase=
                CalculatorDatabase.getInstance(context.getApplicationContext());
        mDao=mDatabase.getDirectionDao();
    }

    public static CalculateRepository getInstance(Context context) {
        if (sInstance==null)
            sInstance=new CalculateRepository(context);
        return sInstance;
    }

    @Override
    public LiveData<DirectionModel> get(int id) {
        return mDao.getDirection(id);
    }

    @Override
    public LiveData<List<DirectionModel>> getList() {
        return mDao.getDirectionList();
    }

    @Override
    public void insert(DirectionModel directionModel) {
        mDatabase.executorService.execute(()->mDao.insert(directionModel));
    }

    @Override
    public void delete(DirectionModel directionModel) {
        mDatabase.executorService.execute(()->mDao.delete(directionModel));
    }

    @Override
    public void update(DirectionModel directionModel) {
        mDatabase.executorService.execute(()->mDao.update(directionModel));
    }
}
