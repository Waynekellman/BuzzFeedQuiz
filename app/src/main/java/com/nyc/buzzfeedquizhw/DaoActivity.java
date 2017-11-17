package com.nyc.buzzfeedquizhw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nyc.buzzfeedquizhw.controller.DaoAdapter;
import com.nyc.buzzfeedquizhw.model.DaoModel;

import java.util.ArrayList;
import java.util.List;

public class DaoActivity extends AppCompatActivity {

    private Button submit;
    private DaoAdapter daoAdapter;
    private LinearLayoutManager layoutManager;
    private RecyclerView daoRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dao);

        daoRecycler = (RecyclerView) findViewById(R.id.recycler_view);
        submit = (Button) findViewById(R.id.submit);

        String[] answerOne = {"A. Red & Purple", "B. Yellow & Gold", "C. White & Silver", "D. Black & Gray", "E. Green & Blue"};
        String[] answerTwo = {"A. Frustration", "B. Sympathy", "C. Grief", "D. Fear", "E. Anger"};
        String[] answerThree = {"A. Spring", "B. Winter", "C. Autumn", "D. Season Transition", "E. Summer"};
        String[] answerFour = {"A. Jupiter", "B. Mercury", "C. venus", "D. Saturn", "E. Mars"};
        String[] answerFive = {"A. Direct", "B. Down to earth", "C. Determined", "D. Creative", "E. Competitive"};
        List<DaoModel> quiz = new ArrayList<>();
        quiz.add(new DaoModel("https://juanmah.files.wordpress.com/2008/10/yinyangyong_4.png",
                "Favorite pair of colors?", answerOne));
        quiz.add(new DaoModel("https://sao.ust.hk/counseling/emotion.jpg",
                "which emotion do you feel the most?",answerTwo));
        quiz.add(new DaoModel("https://behindthekam.files.wordpress.com/2013/04/four-seasons-wallpaper.jpg",
                "Favorite season?", answerThree));
        quiz.add(new DaoModel("https://www.scienceabc.com/wp-content/uploads/2015/09/Solar-System.jpg",
                "Pick a planet!", answerFour));
        quiz.add(new DaoModel("http://t12.deviantart.net/AN7_Hqdly_-ygNeGqMVL1oy0s_g=/fit-in/700x" +
                "350/filters:fixed_height(100,100):origin()/pre02/de2c/th/pre/i/2015/282/8/6/pc__mike_pe" +
                "rsonalities_by_grj1315-d8xk56x.png", "How would your friends describe you?", answerFive));


        daoAdapter = new DaoAdapter(quiz);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        daoRecycler.setAdapter(daoAdapter);
        daoRecycler.setLayoutManager(layoutManager);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(daoAdapter.getChecked(0));
                System.out.println(daoAdapter.getChecked(1));
                System.out.println(daoAdapter.getChecked(2));
                System.out.println(daoAdapter.getChecked(3));
                System.out.println(daoAdapter.getChecked(4));
                if (daoAdapter.getChecked(0) != 0
                        && daoAdapter.getChecked(1) != 0
                        && daoAdapter.getChecked(2) != 0
                        && daoAdapter.getChecked(3) != 0
                        && daoAdapter.getChecked(4) != 0) {
                    Toast.makeText(getApplicationContext(),"You KNOW!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DaoActivity.this,DaoResults.class);
                    intent.putExtra("answerOne",daoAdapter.getChecked(0));
                    intent.putExtra("answerTwo", daoAdapter.getChecked(1));
                    intent.putExtra("answerThree", daoAdapter.getChecked(2));
                    intent.putExtra("answerFour", daoAdapter.getChecked(3));
                    intent.putExtra("answerFive", daoAdapter.getChecked(4));
                    startActivity(intent);
                }
        }});
    }
}
