package com.org.calculator.database;

import android.content.Context;

import com.org.calculator.database.dao.DirectionDao;
import com.org.calculator.model.DirectionModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class CalculateRepository implements IRepository<DirectionModel>{
    private static CalculateRepository sInstance;
    private DirectionDao mDao;
    private CalculateRepository(Context context) {
        CalculatorDatabase database=
                CalculatorDatabase.getInstance(context.getApplicationContext());
        mDao=database.getDirectionDao();
    }

    public static CalculateRepository getInstance(Context context) {
        if (sInstance==null)
            sInstance=new CalculateRepository(context);
        return sInstance;
    }

    @Override
    public Flowable<DirectionModel> get(int id) {
        return mDao.getDirection(id);
    }

    @Override
    public Flowable<List<DirectionModel>> getList() {
        return mDao.getDirectionList();
    }

    @Override
    public Completable insert(DirectionModel directionModel) {
        return mDao.insert(directionModel);
    }

    @Override
    public Completable delete(DirectionModel directionModel) {
        return mDao.delete(directionModel);
    }

    @Override
    public Completable update(DirectionModel directionModel) {
        return mDao.update(directionModel);
    }

}
