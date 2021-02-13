package com.org.calculator.view.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.org.calculator.R;
import com.org.calculator.adapter.CalculateAdapter;
import com.org.calculator.databinding.FragmentShowResultsBinding;
import com.org.calculator.model.CalculateModel;
import com.org.calculator.viewModel.CalculateViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShowResultsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowResultsFragment extends Fragment {
    private FragmentShowResultsBinding mBinding;
    private CalculateAdapter mAdapter;

    private CalculateViewModel mViewModel;

    public ShowResultsFragment() {
        // Required empty public constructor
    }

    public static ShowResultsFragment newInstance() {
        ShowResultsFragment fragment = new ShowResultsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel=new ViewModelProvider(this).get(CalculateViewModel.class);
        mViewModel.getCalculateModelList().observe(this, new Observer<List<CalculateModel>>() {
            @Override
            public void onChanged(List<CalculateModel> calculateModels) {
                setupAdapter(calculateModels);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding= DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_show_results,
                container,
                false);

        return mBinding.getRoot();
    }

    private void setupAdapter(List<CalculateModel> calculateModels) {
        mAdapter=new CalculateAdapter(getContext(),calculateModels);
        mBinding.recyclerView.setAdapter(mAdapter);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}