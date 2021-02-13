package com.org.calculator.database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.org.calculator.database.dao.CalculateDao;
import com.org.calculator.model.CalculateModel;

import java.util.List;

public class CalculateRepository implements IRepository<CalculateModel>{
    private static CalculateRepository sInstance;
    private CalculateDao mDao;
    private CalculatorDatabase mDatabase;


    private CalculateRepository(Context context) {
        mDatabase=CalculatorDatabase.getInstance(context.getApplicationContext());
        mDao=mDatabase.getCalculateDao();
    }

    public static CalculateRepository getInstance(Context context) {
        if (sInstance==null)
            sInstance=new CalculateRepository(context);
        return sInstance;
    }

    @Override
    public LiveData<CalculateModel> get(int id) {
        return mDao.getCalculate(id);
    }

    @Override
    public LiveData<List<CalculateModel>> getList() {
        return mDao.getCalculateList();
    }

    @Override
    public void insert(CalculateModel calculateModel) {
        mDatabase.executorService.execute(()->mDao.insert(calculateModel));
    }

    @Override
    public void delete(CalculateModel calculateModel) {
        mDatabase.executorService.execute(()->mDao.delete(calculateModel));
    }

    @Override
    public void update(CalculateModel calculateModel) {
        mDatabase.executorService.execute(()->mDao.update(calculateModel));
    }
}
