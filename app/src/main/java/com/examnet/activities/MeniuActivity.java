package com.examnet.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.examnet.R;

public class MeniuActivity extends AppCompatActivity {
    Button grila;
    Button complRasp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meniu);

        grila = findViewById(R.id.intrebariGrila);
        complRasp = findViewById(R.id.intrebariComplRaspuns);

        grila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GrilaActivity.class);
                startActivity(intent);
            }
        });

        complRasp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CompleteazaRaspunsActivity.class);
                startActivity(intent);
            }
        });
    }
}