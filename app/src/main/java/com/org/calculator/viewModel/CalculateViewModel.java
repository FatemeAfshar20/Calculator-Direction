package com.org.calculator.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.org.calculator.database.CalculateRepository;

public class CalculateViewModel extends AndroidViewModel {
    private CalculateRepository mRepository;

    public CalculateViewModel(@NonNull Application application) {
        super(application);
        mRepository=CalculateRepository.getInstance(application);
    }


}
