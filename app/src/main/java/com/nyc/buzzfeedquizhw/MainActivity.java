package com.nyc.buzzfeedquizhw;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button introExtro, dao;
    private static final String SHARED_PREFS_KEY = "daoKey";
    private SharedPreferences keepClicked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        introExtro = (Button) findViewById(R.id.intro_extro_quiz);
        dao = (Button) findViewById(R.id.dao_quiz);
        keepClicked = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        keepClicked.edit().clear();
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
