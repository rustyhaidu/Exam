package com.examnet.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.examnet.R;
import com.examnet.adaptors.ExamComplRaspAdaptor;
import com.examnet.adaptors.ExamGrilaAdaptor;
import com.examnet.model.Examen;
import com.examnet.model.Raspunsuri;
import com.examnet.utils.ParseXML;


public class CompleteazaRaspunsActivity extends AppCompatActivity {
    Examen examen;
    ListView listViewIntrebari;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grila);

        examen = ParseXML.getExamen(getApplicationContext());

        listViewIntrebari = findViewById(R.id.listaIntrebariGrila);
        ExamComplRaspAdaptor examGrilaAdaptor = new ExamComplRaspAdaptor(getApplicationContext(),
                R.layout.item_intrebare_compl_rasp, examen.getIntrebari());
        listViewIntrebari.setAdapter(examGrilaAdaptor);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int scor = 0;

                for (int i = 0; i < Raspunsuri.raspunsuriComplRasp.size(); i++) {
                    if (Raspunsuri.raspunsuriComplRasp.get(i).toLowerCase()
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