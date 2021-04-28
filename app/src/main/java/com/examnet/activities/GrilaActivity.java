package com.examnet.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.examnet.R;
import com.examnet.adaptors.ExamGrilaAdaptor;
import com.examnet.adaptors.ExamGrilaRecycleAdapter;
import com.examnet.model.Examen;
import com.examnet.model.Raspunsuri;
import com.examnet.utils.ParseXML;


public class GrilaActivity extends AppCompatActivity {
    Examen examen;
    RecyclerView listViewIntrebari;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grila);

        examen = ParseXML.getExamen(getApplicationContext());
        for (int i = 0; i < examen.getIntrebari().size(); i++) {
            Raspunsuri.raspunsuriGrila.put(i, "");
        }

        listViewIntrebari = findViewById(R.id.listaIntrebariGrila);
        listViewIntrebari.setLayoutManager(new LinearLayoutManager(this));
        ExamGrilaRecycleAdapter examGrilaAdaptor = new ExamGrilaRecycleAdapter(examen.getIntrebari());
        listViewIntrebari.setAdapter(examGrilaAdaptor);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int scor = 0;

                for (int i = 0; i < Raspunsuri.raspunsuriGrila.size(); i++) {
                    if (Raspunsuri.raspunsuriGrila.get(i).equals(examen.getIntrebari().get(i).getRaspuns())) {
                        scor++;
                    }
                }

                Intent intent = new Intent(getApplicationContext(), ScoreActivity.class);
                intent.putExtra("scorGrila", scor);
                startActivity(intent);
            }
        });

    }
}