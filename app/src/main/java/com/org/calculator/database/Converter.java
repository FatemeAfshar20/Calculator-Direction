package com.org.calculator.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.org.calculator.model.CalculateModel;
import com.org.calculator.model.DirectionModel;

import java.util.List;

public class Converter {

    @TypeConverter
    public static String conListToJsonString(List<DirectionModel> calculateModels) {
        return calculateModels == null ? null : new Gson().toJson(calculateModels);
    }

    @TypeConverter
    public static List<DirectionModel> conStringJsonToList(String calculateModelJsonStr) {
        return calculateModelJsonStr == null ? null : new Gson().fromJson(calculateModelJsonStr, new TypeToken<List<DirectionModel>>() {
        }.getType());
    }
}
