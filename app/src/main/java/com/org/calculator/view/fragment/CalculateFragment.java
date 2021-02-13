package com.org.calculator.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.org.calculator.R;
import com.org.calculator.databinding.FragmentCalculateBinding;
import com.org.calculator.model.CalculateModel;
import com.org.calculator.viewModel.CalculateViewModel;
import com.org.calculator.viewModel.MainViewModel;

import java.util.List;

public class CalculateFragment extends DialogFragment {
    private FragmentCalculateBinding mBinding;
    private CalculateViewModel mViewModel;

    private MainViewModel mMainViewModel;

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
        mViewModel = new ViewModelProvider(this).get(CalculateViewModel.class);
        mMainViewModel=new ViewModelProvider(getActivity()).get(MainViewModel.class);

        mViewModel.setDirectionModels(mMainViewModel.getDirectionModels());

        mViewModel.getCommonLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s.equals("CalculateResult")) {
                    mBinding.btnCalculate.setText(mViewModel.getResult() + "");
                    mBinding.btnCancel.setText("Exit");
                    mBinding.btnSave.setVisibility(View.VISIBLE);
                }else if (s.equals("Cancel"))
                    dismiss();
            }
        });
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
        mBinding.setViewModel(mViewModel);
        return mBinding.getRoot();
    }
}