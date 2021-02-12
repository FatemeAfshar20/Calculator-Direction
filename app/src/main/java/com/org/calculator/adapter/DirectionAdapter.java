package com.org.calculator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.org.calculator.R;
import com.org.calculator.databinding.ItemViewBinding;
import com.org.calculator.model.Direction;

import java.util.List;

public class DirectionAdapter extends RecyclerView.Adapter<DirectionAdapter.Holder> {
    private Context mContext;
    private List<Direction> mDirections;

    public DirectionAdapter(Context context, List<Direction> directions) {
        mContext = context;
        mDirections = directions;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemViewBinding binding= DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.item_view,parent,
                false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bindView(mDirections.get(position));
    }

    @Override
    public int getItemCount() {
        return mDirections.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        private ItemViewBinding mBinding;

         public Holder(@NonNull ItemViewBinding binding) {
             super(binding.getRoot());
             mBinding=binding;
         }

         public void bindView(Direction direction){

         }
     }
}
