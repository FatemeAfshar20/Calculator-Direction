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
    private int mId;
    @ColumnInfo(name = Columns.X)
    private double mX;
    @ColumnInfo(name = Columns.Y)
    private double mY;

    public DirectionModel(double x, double y) {
        mX = x;
        mY = y;
    }

    public DirectionModel() {
    }

    public double getX() {
        return mX;
    }

    public void setX(double x) {
        mX = x;
    }

    public double getY() {
        return mY;
    }

    public void setY(double y) {
        mY = y;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }
}
