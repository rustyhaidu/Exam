package com.examnet.model;

import java.util.ArrayList;
import java.util.List;

public class Examen {

    private List<Intrebare> intrebari = new ArrayList<>();

    public List<Intrebare> getIntrebari() {
        return intrebari;
    }

    public void setIntrebari(List<Intrebare> intrebari) {
        this.intrebari = intrebari;
    }
}
