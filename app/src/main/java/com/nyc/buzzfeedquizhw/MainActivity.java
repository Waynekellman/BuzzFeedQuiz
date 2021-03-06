package com.nyc.buzzfeedquizhw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button introExtro, dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        introExtro = (Button) findViewById(R.id.intro_extro_quiz);
        dao = (Button) findViewById(R.id.dao_quiz);
    }

    public void quizChoice(View v) {
        switch (v.getId()) {
            case R.id.intro_extro_quiz:
                Intent intentIntroExtro = new Intent(MainActivity.this, IntroExtroQuiz.class);
                startActivity(intentIntroExtro);
                break;
            case R.id.dao_quiz:
                Intent intentDao = new Intent(MainActivity.this, DaoActivity.class);
                startActivity(intentDao);
        }
    }
}
