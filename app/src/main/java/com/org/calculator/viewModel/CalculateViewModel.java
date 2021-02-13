package com.org.calculator.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.org.calculator.database.CalculateRepository;
import com.org.calculator.model.CalculateModel;
import com.org.calculator.model.DirectionModel;
import com.org.calculator.view.observer.CommonLiveData;

import java.util.ArrayList;
import java.util.List;

public class CalculateViewModel extends AndroidViewModel {
    private CalculateRepository mRepository;

    private CalculateModel mCalculateModel=new CalculateModel();
    private List<DirectionModel> mDirectionModels=new ArrayList<>();

    private DirectionModel mDirectionOne;
    private DirectionModel mDirectionTwo;

    private CommonLiveData<String> mCommonLiveData=new CommonLiveData<>();

    private int mDirectionModelSize;

    private double mResult;

    public CalculateViewModel(@NonNull Application application) {
        super(application);
        mRepository=CalculateRepository.getInstance(application);
    }

    public LiveData<List<CalculateModel>> getCalculateModelList() {
        return mRepository.getList();
    }

    public void setDirectionModels(List<DirectionModel> directionModels) {
        mDirectionModels = directionModels;
        mDirectionModelSize=directionModels.size();

        setupDirections();
    }

    private void setupDirections(){
        if (mDirectionModelSize==0 || mDirectionModelSize<2)
            return;
        mDirectionOne=mDirectionModels.get(mDirectionModelSize-1);
        mDirectionTwo=mDirectionModels.get(mDirectionModelSize-2);
    }

    public DirectionModel getDirectionOne() {
        return mDirectionOne;
    }

    public DirectionModel getDirectionTwo() {
        return mDirectionTwo;
    }

    public void onCalculateBtnListener(){
        mResult=(Math.pow(mDirectionOne.getX(),2)-Math.pow(mDirectionTwo.getX(),2))+
                (Math.pow(mDirectionOne.getY(),2)-Math.pow(mDirectionTwo.getY(),2));

        mCalculateModel.setResult(Math.round(mResult*100)/100);
        mCommonLiveData.setValue("CalculateResult");
    }

    public void onCancelBtnListener(){
        mCommonLiveData.setValue("Cancel");
    }

    public void onSaveBtnListener(){
        mCalculateModel.setDirectionModelList(mDirectionModels);
        mRepository.insert(mCalculateModel);
    }

    public CommonLiveData<String> getCommonLiveData() {
        return mCommonLiveData;
    }

    public double getResult() {
        return mResult;
    }
}
