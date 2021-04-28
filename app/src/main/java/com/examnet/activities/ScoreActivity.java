package com.examnet.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.examnet.R;
import com.examnet.model.Raspunsuri;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreActivity extends AppCompatActivity {

    TextView scorTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scorTv = findViewById(R.id.scorTextView);

        int scorGrila = getIntent().getIntExtra("scorGrila", -1);
        int scorComplRasp = getIntent().getIntExtra("scorComplRasp", -1);
        Map<Integer, String> raspunsuri;

        int scor = 0;
        if (scorGrila == -1) {
            raspunsuri = Raspunsuri.raspunsuriComplRasp;
            scor = scorComplRasp;
        } else {
            scor = scorGrila;
            raspunsuri = Raspunsuri.raspunsuriGrila;
        }

        scorTv.setText("Ai punctat: " + scor + " din " + raspunsuri.size());

    }
}