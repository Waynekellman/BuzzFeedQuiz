package com.nyc.buzzfeedquizhw.views;

/**
 * Created by c4q on 11/14/17.
 */
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.nyc.buzzfeedquizhw.R;
import com.nyc.buzzfeedquizhw.model.IntroExtroModel;
import com.squareup.picasso.Picasso;

public class IntroExtroViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView q1, ans1, ans2, ans3, ans4, ans5;
    private RadioButton boxFive;
    private RadioGroup radioGroup;

    public IntroExtroViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        q1 = (TextView) itemView.findViewById(R.id.question);
        ans1 = (TextView) itemView.findViewById(R.id.answer1);
        ans2 = (TextView) itemView.findViewById(R.id.answer2);
        ans3 = (TextView) itemView.findViewById(R.id.answer3);
        ans4 = (TextView) itemView.findViewById(R.id.answer4);
        ans5 = (TextView) itemView.findViewById(R.id.answer5);
        boxFive = (RadioButton) itemView.findViewById(R.id.button_answer5);
        radioGroup = (RadioGroup) itemView.findViewById(R.id.radio_group);


    }

    public void bind(IntroExtroModel model){

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
        ans5.setVisibility(View.INVISIBLE);
        boxFive.setVisibility(View.INVISIBLE);
    }

    public RadioGroup getView() {
        return radioGroup;
    }
}

