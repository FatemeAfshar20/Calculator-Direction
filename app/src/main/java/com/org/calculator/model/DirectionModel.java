package com.org.calculator.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.org.calculator.database.CalculatorSchema;
import com.org.calculator.database.CalculatorSchema.DirectionTable.Columns;

@Entity(tableName = CalculatorSchema.DirectionTable.NAME)
public class DirectionModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Columns.ID)
    int mId;
    @ColumnInfo(name = Columns.X)
    private int mX;
    @ColumnInfo(name = Columns.Y)
    private int mY;

    public DirectionModel(int x, int y) {
        mX = x;
        mY = y;
    }

    public int getX() {
        return mX;
    }

    public void setX(int x) {
        mX = x;
    }

    public int getY() {
        return mY;
    }

    public void setY(int y) {
        mY = y;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }
}
