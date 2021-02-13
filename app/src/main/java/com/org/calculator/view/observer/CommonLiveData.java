package com.org.calculator.view.observer;

import androidx.lifecycle.MutableLiveData;

public class CommonLiveData<T> extends MutableLiveData<T> {
    private static final CommonLiveData<String> sInstance=new CommonLiveData<>();

    public static CommonLiveData<String> getInstance() {
        return sInstance;
    }
}
