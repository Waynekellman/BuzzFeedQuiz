package com.nyc.buzzfeedquizhw.controller;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import com.nyc.buzzfeedquizhw.R;
import com.nyc.buzzfeedquizhw.model.IntroExtroModel;
import com.nyc.buzzfeedquizhw.views.IntroExtroViewHolder;
import java.util.HashMap;
import java.util.List;

/**
 * Created by c4q on 11/15/17.
 */

public class IntroExtroAdapter extends RecyclerView.Adapter<IntroExtroViewHolder>{
    private List<IntroExtroModel> modelList;
    private IntroExtroViewHolder viewHolder;
    private IntroExtroModel model;

    public IntroExtroAdapter(List<IntroExtroModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public IntroExtroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        viewHolder = new IntroExtroViewHolder(childView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(IntroExtroViewHolder holder, final int position) {
        holder.getView().setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                modelList.get(position).setBoxChecked(i);
                Log.d("onBindVH", "onCheckedChanged: " + i);
            }
        });
        model = modelList.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public int getChecked(int position){
        return modelList.get(position).getBoxChecked();
    }

}


