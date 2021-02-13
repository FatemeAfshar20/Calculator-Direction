package com.org.calculator.view.fragment;

import android.app.DialogFragment;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.org.calculator.R;
import com.org.calculator.databinding.FragmentCalculateBinding;

public class CalculateFragment extends DialogFragment {
    private FragmentCalculateBinding mBinding;

    public CalculateFragment() {
        // Required empty public constructor
    }

    public static CalculateFragment newInstance() {
        CalculateFragment fragment = new CalculateFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding= DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_calculate,
                container,
                false);

        return mBinding.getRoot();
    }
}