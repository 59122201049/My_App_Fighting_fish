package com.example.myappprojcet;

import java.util.ArrayList;
import java.util.List;

public class Bettatwo {
    private int resId1;
    private String breed1;
    private String description1;

    List<Bettatwo> bettastwos = new ArrayList<>();

    Bettatwo() {

    }

    Bettatwo(int resId1, String breed1, String description1) {
        this.resId1 = resId1;
        this.breed1 = breed1;
        this.description1 = description1;
    }
    Bettatwo(int resId1, String breed1) {
        this.resId1 = resId1;
        this.breed1 = breed1;

    }


    public int getResId1() {
        return resId1;
    }

    public void setResId1(int resId1) {
        this.resId1 = resId1;
    }

    public String getBreed1() {
        return breed1;
    }

    public void setBreed1(String breed1) {
        this.breed1 = breed1;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public List<Bettatwo> getBettatwos() {
        return bettastwos;
    }

    public void setBettastwos(List<Bettatwo> bettastwos) {
        this.bettastwos = bettastwos;
    }
}
