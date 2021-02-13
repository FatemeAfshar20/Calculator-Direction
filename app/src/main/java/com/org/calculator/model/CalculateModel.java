package com.org.calculator.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.org.calculator.database.CalculatorSchema;
import com.org.calculator.database.CalculatorSchema.CalculateTable.Columns;

import java.util.List;

@Entity(tableName = CalculatorSchema.CalculateTable.NAME)
public class CalculateModel{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name=Columns.ID)
    private int mId;
    @ColumnInfo(name=Columns.DIRECTIONS)
    private List<DirectionModel> mDirectionModelList;
    @ColumnInfo(name=Columns.RESULT)
    private double mResult;

    public CalculateModel() {
    }

    public CalculateModel(int id, List<DirectionModel> directionModelList, double result) {
        mId = id;
        mDirectionModelList = directionModelList;
        mResult = result;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public List<DirectionModel> getDirectionModelList() {
        return mDirectionModelList;
    }

    public void setDirectionModelList(List<DirectionModel> directionModelList) {
        mDirectionModelList = directionModelList;
    }

    public double getResult() {
        return mResult;
    }

    public void setResult(double result) {
        mResult = result;
    }
}
