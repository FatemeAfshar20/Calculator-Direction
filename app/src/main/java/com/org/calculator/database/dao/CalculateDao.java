package com.org.calculator.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.org.calculator.model.CalculateModel;

import java.util.List;

@Dao
public interface CalculateDao {
    @Query("SELECT * FROM calculateTable")
    LiveData<List<CalculateModel>> getCalculateList();

    @Query("SELECT * FROM calculateTable WHERE id=:id")
    LiveData<CalculateModel> getCalculate(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CalculateModel calculateModel);

    @Delete
    void delete(CalculateModel calculateModel);

    @Update
    void update(CalculateModel calculateModel);
}
