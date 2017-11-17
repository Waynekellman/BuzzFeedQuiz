package com.nyc.buzzfeedquizhw.controller;

import android.content.SharedPreferences;
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

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by c4q on 11/16/17.
 */

public class DaoAdapter extends RecyclerView.Adapter<DaoViewHolder> {

    private static final String SHARED_PREFS_KEY = "daoKey";
    private List<DaoModel> modelList;
    private DaoViewHolder viewHolder;
    private DaoModel model;
    private SharedPreferences keepClicked;

    public DaoAdapter(List<DaoModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public DaoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        viewHolder = new DaoViewHolder(childView);
        keepClicked = parent.getContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DaoViewHolder holder, final int position) {
        holder.getView().setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                SharedPreferences.Editor editor = keepClicked.edit();
                modelList.get(position).setBoxChecked(i);
                editor.putInt(String.valueOf(position),i);
                editor.putBoolean("clicked", true);
                editor.commit();
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
