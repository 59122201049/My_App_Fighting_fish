package com.example.myappprojcet;

import java.util.ArrayList;
import java.util.List;

public class Betta {
    private int resId;
    private String breed;
    private String description;

    List<Betta> bettas = new ArrayList<>();

    Betta() {

    }

    Betta(int resId, String breed, String description) {
        this.resId = resId;
        this.breed = breed;
        this.description = description;
    }
    Betta(int resId, String breed) {
        this.resId = resId;
        this.breed = breed;

    }


    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Betta> getBettas() {
        return bettas;
    }

    public void setBettas(List<Betta> bettas) {
        this.bettas = bettas;
    }
}
