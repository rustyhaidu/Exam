package com.examnet.model;

import java.util.ArrayList;
import java.util.List;

public class Intrebare {
    private String enunt;
    private List<String> varianteRaspuns = new ArrayList<>();
    private String raspuns;

    public String getEnunt() {
        return enunt;
    }

    public void setEnunt(String enunt) {
        this.enunt = enunt;
    }

    public List<String> getVarianteRaspuns() {
        return varianteRaspuns;
    }

    public void setVarianteRaspuns(List<String> varianteRaspuns) {
        this.varianteRaspuns = varianteRaspuns;
    }

    public String getRaspuns() {
        return raspuns;
    }

    public void setRaspuns(String raspuns) {
        this.raspuns = raspuns;
    }
}
