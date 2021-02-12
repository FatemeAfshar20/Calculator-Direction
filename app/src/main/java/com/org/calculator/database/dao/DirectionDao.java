package com.org.calculator.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.org.calculator.model.DirectionModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;


@Dao
public interface DirectionDao {
    @Query("SELECT * FROM directionTable")
    LiveData<List<DirectionModel>> getDirectionList();

    @Query("SELECT * FROM directionTable WHERE id=:id")
    LiveData<DirectionModel> getDirection(int id);

    @Insert
    void insert(DirectionModel directionModel);

    @Delete
    void delete(DirectionModel directionModel);

    @Update
    void update(DirectionModel directionModel);
}
