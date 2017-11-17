package com.nyc.buzzfeedquizhw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.nyc.buzzfeedquizhw.controller.IntroExtroAdapter;
import com.nyc.buzzfeedquizhw.model.IntroExtroModel;

import java.util.ArrayList;
import java.util.List;

public class IntroExtroQuiz extends AppCompatActivity {

    private Button submit;
    private IntroExtroAdapter introExtroAdapter;
    private LinearLayoutManager layoutManager;
    private RecyclerView introExtroRecycler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_extro_quiz);

        submit = (Button) findViewById(R.id.submit);

        introExtroRecycler = (RecyclerView) findViewById(R.id.recycler_view);
        String[] answers1 = {"A. Morning", "B. Noon", "C. Evening", "D. Night"};
        String[] answers2 = {"A. Summer", "B. Autumn", "C. Winter", "D. Spring"};
        String[] answers3 = {"A. Blue", "B. Red", "C. White", "D. Black"};
        String[] answers4 = {"A. Staying home by myself.", "B. Going to the club", "C. Hangout with a small group of friends", "D. None of the above"};
        String[] answers5 = {"A. Outgoing and friendly", "B. Shy and quiet", "C. Both", "D. Neither"};
        List<IntroExtroModel> quiz = new ArrayList<>();
        quiz.add(new IntroExtroModel("https://thumbs.dreamstime.com/b/four-banners-showing-day-cycle-19466450.jpg","What time of day do you like?", answers1));
        quiz.add(new IntroExtroModel("https://thumbs.dreamstime.com/z/four-seasons-4279693.jpg", "What's your favorite season?", answers2));
        quiz.add(new IntroExtroModel("http://hgtvhome.sndimg.com/content/dam/images/hgtv/fullset/2011/7/18/0/HGTV_Color-Wheel-Full_s4x3.jpg.rend.hgtvcom.1280.960.suffix/1400967008479.jpeg","What color do you usually wear?", answers3));
        quiz.add(new IntroExtroModel("http://oi47.tinypic.com/2rddlrr.jpg", "Which choice sounds like a good day?",answers4));
        quiz.add(new IntroExtroModel("http://cdn.playbuzz.com/cdn/ca5cc1b0-8fdc-469d-976c-e5503b79526e/cf3b8a30-2b8e-42e4-841f-068bd5c92547.jpg","How would your friends descride you?", answers5));

        introExtroAdapter = new IntroExtroAdapter(quiz);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        introExtroRecycler.setAdapter(introExtroAdapter);
        introExtroRecycler.setLayoutManager(layoutManager);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(introExtroAdapter.getChecked(0));
                System.out.println(introExtroAdapter.getChecked(1));
                System.out.println(introExtroAdapter.getChecked(2));
                System.out.println(introExtroAdapter.getChecked(3));
                System.out.println(introExtroAdapter.getChecked(4));
                if (introExtroAdapter.getChecked(0) != 0
                        && introExtroAdapter.getChecked(1) != 0
                        && introExtroAdapter.getChecked(2) != 0
                        && introExtroAdapter.getChecked(3) != 0
                        && introExtroAdapter.getChecked(4) != 0) {
                    Toast.makeText(getApplicationContext(), "YESS", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(IntroExtroQuiz.this, IntroExtroResults.class);
                    intent.putExtra("answer1", introExtroAdapter.getChecked(0));
                    intent.putExtra("answer2", introExtroAdapter.getChecked(1));
                    intent.putExtra("answer3", introExtroAdapter.getChecked(2));
                    intent.putExtra("answer4", introExtroAdapter.getChecked(3));
                    intent.putExtra("answer5", introExtroAdapter.getChecked(4));
                    startActivity(intent);
                }

            }
        });
    }



}
