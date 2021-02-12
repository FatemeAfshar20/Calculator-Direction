package com.org.calculator.viewModel;

import android.app.Application;
import android.text.Editable;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.org.calculator.R;
import com.org.calculator.database.CalculateRepository;
import com.org.calculator.model.DirectionModel;
import com.org.calculator.utils.UiUtils;
import com.org.calculator.view.observer.CommonLiveData;

public class AddDialogViewModel extends AndroidViewModel {
    private CalculateRepository mRepository;
    private DirectionModel mDirection;
    private CommonLiveData<Boolean> mCommonLiveData=
            CommonLiveData.getInstance();

    public AddDialogViewModel(@NonNull Application application) {
        super(application);
        mRepository=CalculateRepository.getInstance(application);
        mDirection=new DirectionModel();
    }

    public void onAddBtnClickListener(){
        mRepository.insert(mDirection);
        mCommonLiveData.setValue(false);
        UiUtils.returnToast(getApplication(), R.string.successfully_add);
    }

    public void onCancelBtnClickListener(){
        mCommonLiveData.setValue(false);
    }

    public void afterTextChangeX(Editable editable){
        mDirection.setX(Integer.parseInt(editable.toString()));
    }

    public void afterTextChangeY(Editable editable){
        mDirection.setY(Integer.parseInt(editable.toString()));
    }

    public LiveData<Boolean> getAddBtnEvent() {
        return mCommonLiveData;
    }
}
