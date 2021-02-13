package com.org.calculator.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.org.calculator.database.DirectionRepository;
import com.org.calculator.model.DirectionModel;
import com.org.calculator.view.observer.CommonLiveData;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private DirectionRepository mRepository;

    private CommonLiveData<String> mCommonLiveData;

    private MutableLiveData<List<DirectionModel>> mListMutableLiveData =new MutableLiveData<>();
    private List<DirectionModel> mDirectionModels=new ArrayList<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
        mRepository= DirectionRepository.getInstance(getApplication());
        mCommonLiveData=CommonLiveData.getInstance();
    }

    public void onAddBtnClickListener(){
        mCommonLiveData.setValue("SelectAddBtn");
    }

    public void onListBtnClickListener(){
        mCommonLiveData.setValue("SelectListBtn");
    }

    public void onCalculateBtnClickListener(){
        mCommonLiveData.setValue("SelectCalculateBtn");
    }

    public LiveData<List<DirectionModel>> getDirectionList(){
        return mRepository.getList();
    }

    public CommonLiveData<String> getCommonLiveData() {
        return mCommonLiveData;
    }

    public MutableLiveData<List<DirectionModel>> getListMutableLiveData() {
        return mListMutableLiveData;
    }

     public List<DirectionModel> getDirectionModels() {
        return mDirectionModels;
    }

    public void setDirectionModels(List<DirectionModel> directionModels) {
        mDirectionModels = directionModels;
    }
}
