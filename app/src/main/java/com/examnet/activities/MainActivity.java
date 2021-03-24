package com.examnet.activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.examnet.R;
import com.examnet.adaptors.ExamAdaptor;
import com.examnet.model.Examen;
import com.examnet.utils.ParseXML;


public class MainActivity extends AppCompatActivity {
    Examen examen;
    ListView listViewIntrebari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        examen = ParseXML.getExamen(getApplicationContext());

        listViewIntrebari = findViewById(R.id.listaIntrebari);
        ExamAdaptor examAdaptor = new ExamAdaptor(getApplicationContext(), R.layout.item_intrebare, examen.getIntrebari());
        listViewIntrebari.setAdapter(examAdaptor);

    }
}