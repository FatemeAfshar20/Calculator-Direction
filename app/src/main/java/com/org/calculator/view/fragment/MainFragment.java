package com.org.calculator.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.org.calculator.R;
import com.org.calculator.adapter.DirectionAdapter;
import com.org.calculator.databinding.FragmentMainBinding;
import com.org.calculator.model.DirectionModel;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    private FragmentMainBinding mBinding;
    private DirectionAdapter mAdapter;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_main,
                container,
                false);
        setupAdapter(new ArrayList<>());
        return mBinding.getRoot();
    }

    private void setupAdapter(ArrayList<DirectionModel> directionModels) {
        mAdapter = new DirectionAdapter(getActivity(), directionModels);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBinding.recyclerView.setAdapter(mAdapter);
    }
}