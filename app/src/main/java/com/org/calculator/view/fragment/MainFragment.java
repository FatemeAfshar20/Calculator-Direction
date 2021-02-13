package com.org.calculator.view.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.org.calculator.R;
import com.org.calculator.adapter.DirectionAdapter;
import com.org.calculator.databinding.FragmentMainBinding;
import com.org.calculator.model.DirectionModel;
import com.org.calculator.utils.ProgramConstant;
import com.org.calculator.viewModel.MainViewModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.schedulers.Schedulers;


public class MainFragment extends Fragment {
    public static final String FRAGMENT_TAG = "AddDialogFragmentTag";
    public static final int REQUEST_CODE_ADD_DIRECTION = 1;
    private FragmentMainBinding mBinding;
    private DirectionAdapter mAdapter;
    private MainViewModel mViewModel;

    public MainFragment() {
        // Required empty public constructor
    }


    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mViewModel.getDirectionList().observe(this, new Observer<List<DirectionModel>>() {
            @Override
            public void onChanged(List<DirectionModel> directionModels) {
                setupAdapter(directionModels);
            }
        });

        mViewModel.getCommonLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                AddDirectionDialogFragment addDirectionDialogFragment =
                        AddDirectionDialogFragment.newInstance();

                addDirectionDialogFragment.
                        setTargetFragment(MainFragment.this, REQUEST_CODE_ADD_DIRECTION);

                addDirectionDialogFragment.
                        show(MainFragment.this.getParentFragmentManager(), FRAGMENT_TAG);;
            }
        });
    }

    @SuppressLint("CheckResult")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_main,
                container,
                false);
        mBinding.setViewModel(mViewModel);
        return mBinding.getRoot();
    }

    private void setupAdapter(List<DirectionModel> directionModels) {
        mAdapter = new DirectionAdapter(getActivity(), directionModels);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBinding.recyclerView.setAdapter(mAdapter);

        mAdapter.setMainViewModel(mViewModel);
    }

}