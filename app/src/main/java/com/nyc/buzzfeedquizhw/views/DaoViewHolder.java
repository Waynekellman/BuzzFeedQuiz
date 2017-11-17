package com.nyc.buzzfeedquizhw.views;

import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.nyc.buzzfeedquizhw.R;
import com.nyc.buzzfeedquizhw.model.DaoModel;
import com.squareup.picasso.Picasso;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by c4q on 11/16/17.
 */

public class DaoViewHolder extends RecyclerView.ViewHolder {

    private static final String SHARED_PREFS_KEY = "daoKey";
    private ImageView imageView;
    private TextView q1, ans1, ans2, ans3, ans4, ans5;
    private RadioGroup radioGroup;
    private SharedPreferences keepClicked;


    public DaoViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        q1 = (TextView) itemView.findViewById(R.id.question);
        ans1 = (TextView) itemView.findViewById(R.id.answer1);
        ans2 = (TextView) itemView.findViewById(R.id.answer2);
        ans3 = (TextView) itemView.findViewById(R.id.answer3);
        ans4 = (TextView) itemView.findViewById(R.id.answer4);
        ans5 = (TextView) itemView.findViewById(R.id.answer5);
        radioGroup = (RadioGroup) itemView.findViewById(R.id.radio_group);
        keepClicked = itemView.getContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

    }

    public void bind(DaoModel model){

        Picasso.with(imageView.getContext())
                .load(model.getUrl())
                .placeholder(R.drawable.spring)   // optional
                .error(R.drawable.spring)      // optional
                .resize(230, 230)
                .into(imageView);
        q1.setText(model.getQuestion());
        ans1.setText(model.getAnswer()[0]);
        ans2.setText(model.getAnswer()[1]);
        ans3.setText(model.getAnswer()[2]);
        ans4.setText(model.getAnswer()[3]);
        ans5.setText(model.getAnswer()[4]);
        setChecked(0);
        setChecked(1);
        setChecked(2);
        setChecked(3);
        setChecked(4);


    }
    public RadioGroup getView() {
        return radioGroup;
    }
    public void setChecked(int position) {
        if(keepClicked.getBoolean("clicked", false)) {
            if (keepClicked.getInt(String.valueOf(position),0) == 2131165228) {
                radioGroup.check(radioGroup.getChildAt(3).getId());
            } else if (keepClicked.getInt(String.valueOf(position),0) == 2131165227) {
                radioGroup.check(keepClicked.getInt("1", 0));
            } else if (keepClicked.getInt(String.valueOf(position),0) == 2131165226) {
                radioGroup.check(keepClicked.getInt("1", 0));
            } else if (keepClicked.getInt(String.valueOf(position),0) == 2131165225) {
                radioGroup.check(keepClicked.getInt("1", 0));
            }
        }
    }

}
