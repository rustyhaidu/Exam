package com.examnet.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.examnet.R;
import com.examnet.adaptors.ExamComplRaspAdaptor;
import com.examnet.adaptors.ExamComplRaspRecycleAdapter;
import com.examnet.model.Examen;
import com.examnet.model.Raspunsuri;
import com.examnet.utils.ParseXML;

import java.util.Objects;


public class CompleteazaRaspunsActivity extends AppCompatActivity {
    Examen examen;
    RecyclerView listViewIntrebari;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grila);

        examen = ParseXML.getExamen(getApplicationContext());
        for (int i = 0; i < examen.getIntrebari().size(); i++) {
            Raspunsuri.raspunsuriComplRasp.put(i, "");
        }

        listViewIntrebari = findViewById(R.id.listaIntrebariGrila);
        listViewIntrebari.setLayoutManager(new LinearLayoutManager(this));
        ExamComplRaspRecycleAdapter examGrilaAdaptor = new ExamComplRaspRecycleAdapter(examen.getIntrebari());
        listViewIntrebari.setAdapter(examGrilaAdaptor);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int scor = 0;

                for (int i = 0; i < Raspunsuri.raspunsuriComplRasp.size(); i++) {
                    if (Objects.requireNonNull(Raspunsuri.raspunsuriComplRasp.get(i)).trim().toLowerCase()
                            .equals(examen.getIntrebari().get(i).getRaspuns().toLowerCase())) {
                        scor++;
                    }
                }

                Intent intent = new Intent(getApplicationContext(), ScoreActivity.class);
                intent.putExtra("scorComplRasp", scor);
                startActivity(intent);
            }
        });

    }
}