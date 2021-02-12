package com.org.calculator.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.org.calculator.database.dao.DirectionDao;
import com.org.calculator.model.DirectionModel;

@Database(entities = {DirectionModel.class},version = CalculatorSchema.VERSION)
public abstract class CalculatorDatabase extends RoomDatabase {
    private static CalculatorDatabase sInstance;

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
