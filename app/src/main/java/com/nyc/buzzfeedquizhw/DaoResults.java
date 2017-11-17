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

public class DaoResults extends AppCompatActivity {

    private int answer1;
    private int answer2;
    private int answer3;
    private int answer4;
    private int answer5;

    private int countFire = 0;
    private int countEarth= 0;
    private int countMetal = 0;
    private int countWater = 0;
    private int countWood = 0;

    private LinearLayout linearLayout;
    private TextView textView;
    private ImageView imageView;
    private Button go_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dao_results);
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
                Intent intentBack = new Intent(DaoResults.this, MainActivity.class);
                startActivity(intentBack);
            }
        });
    }
    public String[] calculateResults(){
        switch (answer1) {
            case 2131165225:
                countFire++;
                break;
            case 2131165226:
                countEarth++;
                break;
            case 2131165227:
                countMetal++;
                break;
            case 2131165228:
                countWater++;
                break;
            case 2131165229:
                countWood++;
                break;
        }
        switch (answer2) {
            case 2131165225:
                countFire++;
                break;
            case 2131165226:
                countEarth++;
                break;
            case 2131165227:
                countMetal++;
                break;
            case 2131165228:
                countWater++;
                break;
            case 2131165229:
                countWood++;
                break;
        }
        switch (answer3) {
            case 2131165225:
                countWood++;
                break;
            case 2131165226:
                countWater++;
                break;
            case 2131165227:
                countMetal++;
                break;
            case 2131165228:
                countEarth++;
                break;
            case 2131165229:
                countFire++;
                break;
        }
        switch (answer4) {
            case 2131165225:
                countWood++;
                break;
            case 2131165226:
                countWater++;
                break;
            case 2131165227:
                countMetal++;
                break;
            case 2131165228:
                countEarth++;
                break;
            case 2131165229:
                countFire++;
                break;
        }
        switch (answer5) {
            case 2131165225:
                countFire++;
                break;
            case 2131165226:
                countEarth++;
                break;
            case 2131165227:
                countMetal++;
                break;
            case 2131165228:
                countWater++;
                break;
            case 2131165229:
                countWood++;
                break;
        }

        int[] resultsComplete = {countFire,countEarth,countMetal,countWood,countWater};
        int holdMaxResult = countFire;
        for (int i: resultsComplete) {
            if (i > holdMaxResult){
                holdMaxResult = i;
            }
        }
        if (holdMaxResult == countFire) {
            String firePic = "https://www.ifsecglobal.com/wp-content/uploads/2016/06/fire2.png";
            String fireResult = "Fire personality types are very sociable and like to meet new people." +
                    " They love social engagements and connecting people with other people or with the " +
                    "resources they need. They are warm, friendly, the life of the party. They know a lot" +
                    " of people but struggle to connect with people one-on-one. They love to make grand" +
                    " plans and start projects enthusiastically, but get dejected easily when they find " +
                    "obstacles. Connection is what they live for. Their downfall is boredom, which can " +
                    "turn into apathy.";
            String[] fire = {firePic,fireResult};
            return fire;
        } else if (holdMaxResult == countEarth) {
            String earthPic = "https://i.pinimg.com/736x/81/15/55/81155536fb1ad1a86ef3af4e1308c9bf.jpg";
            String earthResult = "Earth personality types want to be the center of their world, not to" +
                    " keep the attention on themselves, but to be of service. They express love by" +
                    " being thoughtful, so they have a lot of attention to detail. They are always " +
                    "aware of the needs of the people around them and they love to provide nurturing. " +
                    "They are constantly thinking about how to improve the lives of their family " +
                    "and friends. They tend to forget themselves and disregard their own needs and " +
                    "desires. They are quick to resent anyone who refuses their help, or who does not " +
                    "want to let them in. Their downfall are worries.";
            String[] earth = {earthPic,earthResult};
            return earth;
        } else if (holdMaxResult == countMetal) {
            String metalPic = "http://images-of-elements.com/titanium-crystal.jpg";
            String metalResult = "Metal personality types tend to be very grounded (after all, metals " +
                    "are extracted from within the earth), but they crave spirituality. Finding the" +
                    " truth in all things is very important to them. They welcome the rules that come " +
                    "with faith or religious practice. They like to live and do things “by the book." +
                    "” They demand that other people follow the rules, but they tend to be more lenient " +
                    "with themselves. When they break the rules, they feel anxious, and when the swing " +
                    "goes back (from what they believe is sinful behavior) they can easily become dogmatic " +
                    "and rigid. They want to do “the right thing.” Their downfall is living in the past.";
            String[] metal = {metalPic, metalResult};
            return metal;
        } else if (holdMaxResult == countWater) {
            String waterPic = "http://www.dudegrows.com/wp-content/uploads/water-background-42.jpg";
            String waterResult = "Water personality types care a lot about flow. The worst thing that " +
                    "can happen to them is to get stuck, at work, in a relationship, or in anything else " +
                    "that they consider important. They love research, and can hardly resist a mystery. They" +
                    " like making money, and love doing things that will generate more money. They like having " +
                    "money at hand, because money means possibilities and purchasing power. Feeling free is " +
                    "very important to them. Their downfall is fear." +
                    "just something I can do to breath.";
            String[] water = {waterPic,waterResult};
            return water;
        } else if (holdMaxResult == countWood) {
            String woodPic = "Ehttp://photos3.meetupstatic.com/photos/event/8/4/b/e/event_114573982.jpeg";
            String woodResult = "Wood personality types can be extremely hard working. They are concerned " +
                    "about productivity and investments. They are always coming up with projects to work on" +
                    " at home, and assign family members to help, whether they like it or not. They like being" +
                    " outdoors but only as long as they are doing something that involves work. For example," +
                    " they will spend a long time working on the yard, but they find it very hard to just lie " +
                    "in a hammock and enjoy a beautiful day. Feeling useful is very important to them. Their " +
                    "downfall is indecision, when they can’t make decisions they easily get angry.";
            String[] wood = {woodPic,woodResult};
            return wood;
        }
        return new String[0];
    }
}
