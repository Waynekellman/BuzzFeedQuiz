package com.nyc.buzzfeedquizhw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class IntroExtroResults extends AppCompatActivity {

    private int answer1;
    private int answer2;
    private int answer3;
    private int answer4;
    private int answer5;

    private int countIntroMajor = 0;
    private int countIntroMinor = 0;
    private int countExtroMajor = 0;
    private int countExtroMinor = 0;

    private LinearLayout linearLayout;
    private TextView textView;
    private ImageView imageView;
    private Button go_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_extro_results);
        Intent intent = getIntent();
        answer1 = intent.getIntExtra("answer1",0);
        answer2 = intent.getIntExtra("answer2",0);
        answer3 = intent.getIntExtra("answer3",0);
        answer4 = intent.getIntExtra("answer4",0);
        answer5 = intent.getIntExtra("answer5",0);

        String[] results = calculateResults();

        linearLayout = (LinearLayout) findViewById(R.id.result_layout);
        textView = (TextView) findViewById(R.id.result_text);
        imageView = (ImageView) findViewById(R.id.imageView);

        go_back = (Button) findViewById(R.id.go_back);

        Picasso.with(linearLayout.getContext())
                .load(results[0])
                .placeholder(R.drawable.spring)   // optional
                .error(R.drawable.spring)      // optional
                .resize(230, 230)
                .into(imageView);
        textView.setText(results[1]);

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(IntroExtroResults.this, MainActivity.class);
                startActivity(intentBack);
            }
        });


    }

    public String[] calculateResults(){
        switch (answer1) {
            case 2131165225:
                countExtroMajor++;
                break;
            case 2131165226:
                countExtroMinor++;
                break;
            case 2131165227:
                countIntroMinor++;
                break;
            case 2131165228:
                countIntroMajor++;
                break;
        }
        switch (answer2) {
            case 2131165225:
                countExtroMajor++;
                break;
            case 2131165226:
                countIntroMinor++;
                break;
            case 2131165227:
                countIntroMajor++;
                break;
            case 2131165228:
                countExtroMinor++;
                break;
        }
        switch (answer3) {
            case 2131165225:
                countExtroMajor++;
                break;
            case 2131165226:
                countIntroMinor++;
                break;
            case 2131165227:
                countExtroMinor++;
                break;
            case 2131165228:
                countIntroMajor++;
                break;
        }
        switch (answer4) {
            case 2131165225:
                countIntroMajor++;
                break;
            case 2131165226:
                countExtroMajor++;
                break;
            case 2131165227:
                countExtroMinor++;
                break;
            case 2131165228:
                countIntroMinor++;
                break;
        }
        switch (answer5) {
            case 2131165225:
                countExtroMajor++;
                break;
            case 2131165226:
                countIntroMajor++;
                break;
            case 2131165227:
                countExtroMinor++;
                break;
            case 2131165228:
                countIntroMinor++;
                break;
        }

        int[] resultsComplete = {countExtroMajor,countExtroMinor,countIntroMajor,countIntroMinor};
        int holdMaxResult = countExtroMajor;
        for (int i: resultsComplete) {
            if (i > holdMaxResult){
                holdMaxResult = i;
            }
        }
        if (holdMaxResult == countExtroMajor) {
            String extroMajorPic = "http://www.jobsite.co.uk/worklife/files/2015/02/extroverts_750x4001.jpg";
            String extroMajorResult = "I like getting my energy from active involvement in " +
                    "events and having a lot of different activities. I'm excited when I'm around " +
                    "people and I like to energize other people. I like moving into action and making " +
                    "things happen. I generally feel at home in the world. I often understand a problem " +
                    "better when I can talk out loud about it and hear what others have to say.";
            String[] extroMajor = {extroMajorPic,extroMajorResult};
            return extroMajor;
        } else if (holdMaxResult == countIntroMajor) {
            String introMajorPic = "https://pbs.twimg.com/profile_images/529645369840635905/M-LeKlKw_400x400.jpeg";
            String introMajorResult = "I like getting my energy from dealing with the ideas, pictures," +
                    " memories, and reactions that are inside my head, in my inner world. I often prefer" +
                    " doing things alone or with one or two people I feel comfortable with. I take time to" +
                    " reflect so that I have a clear idea of what I'll be doing when I decide to act. Ideas are almost" +
                    " solid things for me. Sometimes I like the idea of something better than the real thing.";
            String[] introMajor = {introMajorPic,introMajorResult};
            return introMajor;
        } else if (holdMaxResult == countExtroMinor) {
            String extroMinorPic = "http://www.threekeylife.com/wp-content/uploads/2016/08/intro.jpg";
            String extroMinorResult = "I like getting work done alone. It helps me concentrate when I am" +
                    "working on a project or homework, but when that's done I need to go out and interact with others " +
                    "or loneliness. I tend to be shy around people you just met but once you get accustomed to " +
                    "them you are as outgoing as the best of them. ";
            String[] extroMinor = {extroMinorPic, extroMinorResult};
            return extroMinor;
        } else if (holdMaxResult == countIntroMinor) {
            String introMinorPic = "https://cdn.shopify.com/s/files/1/1779/2115/products/nt9YZHXMcyZtUkKC9M4F2ZawcUHe8X-left_grande.png?v=1488746509";
            String introMinorResults = "I like going out to a party and hanging out with my friends but " +
                    "after a hangout session I need time to myself to recharge. I'm very social and outgoing and " +
                    "outgoing, I just need a little time to myself; reading, writing, meditating, " +
                    "just something I can do to breath.";
            String[] introMinor = {introMinorPic,introMinorResults};
            return introMinor;
        }
        return new String[0];
    }
}
