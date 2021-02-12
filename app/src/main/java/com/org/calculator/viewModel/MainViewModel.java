package com.org.calculator.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.org.calculator.database.CalculateRepository;
import com.org.calculator.model.DirectionModel;
import com.org.calculator.view.observer.CommonLiveData;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class MainViewModel extends AndroidViewModel {
    private CalculateRepository mRepository;
    private CommonLiveData<Boolean> mCommonLiveData;

    private List<DirectionModel> mDirectionModels=new ArrayList<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
        mRepository=CalculateRepository.getInstance(getApplication());
        mCommonLiveData=CommonLiveData.getInstance();
    }

    public void onAddBtnClickListener(){
        mCommonLiveData.setValue(true);
    }

    public LiveData<List<DirectionModel>> getDirectionList(){
        return mRepository.getList();
    }

    public CommonLiveData<Boolean> getCommonLiveData() {
        return mCommonLiveData;
    }

    public List<DirectionModel> getDirectionModels() {
        return mDirectionModels;
    }

    public void setDirectionModels(List<DirectionModel> directionModels) {
        mDirectionModels = directionModels;
    }
}
