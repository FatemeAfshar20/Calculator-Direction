package com.org.calculator.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.org.calculator.database.CalculateRepository;
import com.org.calculator.model.DirectionModel;

import java.util.List;

import io.reactivex.Flowable;

public class MainViewModel extends AndroidViewModel {
    private CalculateRepository mRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mRepository=CalculateRepository.getInstance(getApplication());
    }

    public Flowable<List<DirectionModel>> getDirectionList(){
        return mRepository.getList();
    }
}
