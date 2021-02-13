package com.org.calculator.view.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.org.calculator.R;
import com.org.calculator.databinding.FragmentAddDialogBinding;
import com.org.calculator.viewModel.AddDialogViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddDirectionDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddDirectionDialogFragment extends DialogFragment {
    private FragmentAddDialogBinding mBinding;
    private AddDialogViewModel mViewModel;

    public AddDirectionDialogFragment() {
        // Required empty public constructor
    }

    public static AddDirectionDialogFragment newInstance() {
        AddDirectionDialogFragment fragment = new AddDirectionDialogFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel=new ViewModelProvider(this).get(AddDialogViewModel.class);

        mViewModel.getAddBtnEvent().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s.equals("AddingNewDirection")) {
                    dismiss();
                    sendData();
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding= DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_add_dialog,
                container,
                false);
        mBinding.setViewModel(mViewModel);
        return mBinding.getRoot();
    }

    public void sendData(){
        Intent intent=new Intent();
        Fragment fragment=getTargetFragment();
        int targetRequestCode=getTargetRequestCode();

        fragment.onActivityResult(targetRequestCode, Activity.RESULT_OK,intent);
    }
}