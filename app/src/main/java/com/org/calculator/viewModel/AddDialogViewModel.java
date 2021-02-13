package com.org.calculator.viewModel;

import android.app.Application;
import android.text.Editable;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.org.calculator.R;
import com.org.calculator.database.DirectionRepository;
import com.org.calculator.model.DirectionModel;
import com.org.calculator.utils.UiUtils;
import com.org.calculator.view.observer.CommonLiveData;

public class AddDialogViewModel extends AndroidViewModel {
    private DirectionRepository mRepository;
    private DirectionModel mDirection;
    private CommonLiveData<String> mCommonLiveData=
            CommonLiveData.getInstance();

    public AddDialogViewModel(@NonNull Application application) {
        super(application);
        mRepository= DirectionRepository.getInstance(application);
        mDirection=new DirectionModel();
    }

    public void onAddBtnClickListener(){
        mRepository.insert(mDirection);
        mCommonLiveData.setValue("AddingNewDirection");
        UiUtils.returnToast(getApplication(), R.string.successfully_add);
    }

    public void onCancelBtnClickListener(){
        mCommonLiveData.setValue("AddingNewDirection");
    }

    public void afterTextChangeX(Editable editable){
        mDirection.setX(Double.parseDouble(editable.toString()));
    }

    public void afterTextChangeY(Editable editable){
        mDirection.setY(Double.parseDouble(editable.toString()));
    }

    public LiveData<String> getAddBtnEvent() {
        return mCommonLiveData;
    }
}
