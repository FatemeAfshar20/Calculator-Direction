package com.org.calculator.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.org.calculator.model.DirectionModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

@Dao
public interface DirectionDao {
    @Query("SELECT * FROM directionTable")
    Flowable<List<DirectionModel>> getDirectionList();

    @Query("SELECT * FROM directionTable WHERE id=:id")
    Flowable<DirectionModel> getDirection(int id);

    @Insert
    Completable insert(DirectionModel directionModel);

    @Delete
    Completable delete(DirectionModel directionModel);

    @Update
    Completable update(DirectionModel directionModel);
}
