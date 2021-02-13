package com.org.calculator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.org.calculator.R;
import com.org.calculator.databinding.ItemResultBinding;
import com.org.calculator.model.CalculateModel;
import com.org.calculator.viewModel.CalculateViewModel;

import java.util.List;

public class CalculateAdapter extends RecyclerView.Adapter<CalculateAdapter.Holder> {
    private Context mContext;
    private List<CalculateModel> mCalculateModels;

    public CalculateAdapter(Context context, List<CalculateModel> calculateModels) {
        mContext = context;
        mCalculateModels = calculateModels;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemResultBinding binding= DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.item_result,
                parent,
                false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bindView(mCalculateModels.get(position));
    }

    @Override
    public int getItemCount() {
        return mCalculateModels.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        private ItemResultBinding mBinding;

        public Holder(@NonNull ItemResultBinding binding) {
            super(binding.getRoot());
            mBinding=binding;
        }

        public void bindView(CalculateModel calculateModel){
                mBinding.setCalculateModel(calculateModel);
                mBinding.setCounter(mCalculateModels.indexOf(calculateModel));
        }
    }
}
