package com.examnet.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.examnet.R;
import com.examnet.model.Raspunsuri;

public class ScoreActivity extends AppCompatActivity {

    TextView scorTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scorTv = findViewById(R.id.scorTextView);

        int scorGrila = getIntent().getIntExtra("scorGrila", 0);
        int scorComplRasp = getIntent().getIntExtra("scorComplRasp", 0);

        int scor = 0;
        if (scorGrila == 0) {
            scor = scorComplRasp;
        } else {
            scor = scorGrila;
        }

        scorTv.setText("Ai punctat: " + scor + " din " + Raspunsuri.raspunsuriGrila.size());

    }
}