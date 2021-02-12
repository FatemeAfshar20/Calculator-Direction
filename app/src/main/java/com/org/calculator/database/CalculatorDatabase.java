package com.org.calculator.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.org.calculator.database.dao.DirectionDao;
import com.org.calculator.model.DirectionModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {DirectionModel.class},version = CalculatorSchema.VERSION)
public abstract class CalculatorDatabase extends RoomDatabase {
    private static CalculatorDatabase sInstance;

    public  ExecutorService executorService= Executors.newFixedThreadPool(5);

    public static CalculatorDatabase getInstance(Context context) {
        if (sInstance==null)
            sInstance= Room.databaseBuilder(
                    context,
                    CalculatorDatabase.class,
                    CalculatorSchema.NAME).
                    build();
        return sInstance;
    }

    public abstract DirectionDao getDirectionDao();
}
