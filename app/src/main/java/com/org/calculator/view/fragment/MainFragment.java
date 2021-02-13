package com.org.calculator.view.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.org.calculator.R;
import com.org.calculator.adapter.DirectionAdapter;
import com.org.calculator.databinding.FragmentMainBinding;
import com.org.calculator.model.DirectionModel;
import com.org.calculator.viewModel.MainViewModel;

import java.util.List;


public class MainFragment extends Fragment {
    public static final String FRAGMENT_TAG = "AddDialogFragmentTag";
    public static final int REQUEST_CODE_ADD_DIRECTION = 1;
    public static final int REQUEST_CODE_CALCULATE_DIRECTION = 2;
    private FragmentMainBinding mBinding;
    private DirectionAdapter mAdapter;
    private MainViewModel mViewModel;

    private MainFragmentCallback mCallback;

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
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof MainFragmentCallback)
            mCallback = (MainFragmentCallback) context;
        else
            throw new ClassCastException("At first implementation MainFragmentCallback interface");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
        mViewModel.getCommonLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                switch (s) {
                    case "SelectAddBtn":
                        AddDirectionDialogFragment addDirectionDialogFragment =
                                AddDirectionDialogFragment.newInstance();

                        addDirectionDialogFragment.
                                setTargetFragment(MainFragment.this, REQUEST_CODE_ADD_DIRECTION);

                        addDirectionDialogFragment.
                                show(MainFragment.this.getParentFragmentManager(), FRAGMENT_TAG);
                        break;
                    case "SelectCalculateBtn":
                        CalculateFragment calculateFragment =
                                CalculateFragment.newInstance();

                        calculateFragment.
                                setTargetFragment(MainFragment.this, REQUEST_CODE_CALCULATE_DIRECTION);

                        calculateFragment.
                                show(MainFragment.this.getParentFragmentManager(), FRAGMENT_TAG);
                        break;
                    case "SelectListBtn":
                        mCallback.onListBtnClickListener();
                        break;
                }
            }
        });

        mViewModel.getListMutableLiveData().observe(this, new Observer<List<DirectionModel>>() {
            @Override
            public void onChanged(List<DirectionModel> directionModels) {
                if (directionModels.size() >= 2) {
                    mBinding.btnCalculate.setVisibility(View.VISIBLE);
                    mViewModel.setDirectionModels(directionModels);
                } else
                    mBinding.btnCalculate.setVisibility(View.GONE);
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

        if (mViewModel.getDirectionModels().size()!=0)
            setupAdapter(mViewModel.getDirectionModels());

        return mBinding.getRoot();
    }

    private void setupAdapter(List<DirectionModel> directionModels) {
        mAdapter = new DirectionAdapter(getActivity(), directionModels);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBinding.recyclerView.setAdapter(mAdapter);

        mAdapter.setMainViewModel(mViewModel);
    }

    public interface MainFragmentCallback {
        void onListBtnClickListener();
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.getDirectionList().observe(this, new Observer<List<DirectionModel>>() {
            @Override
            public void onChanged(List<DirectionModel> directionModels) {
                setupAdapter(directionModels);
            }
        });
    }
}