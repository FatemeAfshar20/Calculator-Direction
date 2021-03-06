package com.org.calculator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.org.calculator.R;
import com.org.calculator.databinding.ItemViewBinding;
import com.org.calculator.model.DirectionModel;
import com.org.calculator.viewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class DirectionAdapter extends RecyclerView.Adapter<DirectionAdapter.Holder> {
    private Context mContext;
    private List<DirectionModel> mDirectionModels;

    private List<DirectionModel> mSelectedDirectionModels=new ArrayList<>();

    private MainViewModel mMainViewModel;

    public DirectionAdapter(Context context, List<DirectionModel> directionModels) {
        mContext = context;
        mDirectionModels = directionModels;
    }

    public void setMainViewModel(MainViewModel mainViewModel) {
        mMainViewModel = mainViewModel;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemViewBinding binding= DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.item_view,
                parent,
                false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bindView(mDirectionModels.get(position));

        holder.mBinding.chbSelection.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    mSelectedDirectionModels.add(mDirectionModels.get(position));
                }else {
                    mSelectedDirectionModels.remove(mDirectionModels.get(position));
                }

                mMainViewModel.getListMutableLiveData().postValue(mSelectedDirectionModels);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDirectionModels.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        private ItemViewBinding mBinding;

         public Holder(@NonNull ItemViewBinding binding) {
             super(binding.getRoot());
             mBinding=binding;
         }

         public void bindView(DirectionModel directionModel){
            mBinding.setDirectionModel(directionModel);
            mBinding.setCounter(mDirectionModels.indexOf(directionModel));
         }
     }
}
