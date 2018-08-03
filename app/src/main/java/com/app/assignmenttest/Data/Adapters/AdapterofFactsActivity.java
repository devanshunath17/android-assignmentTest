package com.app.assignmenttest.Data.Adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.app.assignmenttest.R;
import com.app.assignmenttest.Ui.Entity.ListItem;
import com.app.assignmenttest.databinding.RowBinding;


import java.util.ArrayList;

/**
 * Created by Devanshu Nath Tripathi on 17/7/18.
 */

public class AdapterofFactsActivity extends RecyclerView.Adapter<AdapterofFactsActivity.MyViewHolder> {

    private ArrayList<ListItem> factsList;
    private Context mcontaxt;
    private LayoutInflater layoutInflater;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //Databinding auto genrate class
        private final RowBinding binding;
        public MyViewHolder(final RowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }

    }

    public AdapterofFactsActivity(Context mcontaxt, ArrayList<ListItem> factslist) {
        this.factsList = factslist;
        this.mcontaxt = mcontaxt;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        RowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.row, parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.binding.setListitem(factsList.get(position));

    }

    @Override
    public int getItemCount() {
        return factsList.size();
    }
}
