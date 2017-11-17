package com.nyc.buzzfeedquizhw.controller;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import com.nyc.buzzfeedquizhw.R;
import com.nyc.buzzfeedquizhw.model.DaoModel;
import com.nyc.buzzfeedquizhw.views.DaoViewHolder;
import java.util.HashMap;
import java.util.List;

/**
 * Created by c4q on 11/16/17.
 */

public class DaoAdapter extends RecyclerView.Adapter<DaoViewHolder> {

    private List<DaoModel> modelList;
    private DaoViewHolder viewHolder;
    private DaoModel model;
    private HashMap<Integer,RadioGroup> viewPosition = new HashMap<>();
    public DaoAdapter(List<DaoModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public DaoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        viewHolder = new DaoViewHolder(childView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DaoViewHolder holder, final int position) {
        viewPosition.put(position,holder.getView());
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

    public HashMap<Integer, RadioGroup> getViewPosition() {
        return viewPosition;
    }
}
