package com.m2iformation.locationvoiture.model;

import java.time.LocalDateTime;

public class Loc {
    private String voiture;
    private String client;
    private String date;
    private int duree; // en jour
    private Double prix;

    public Loc(){}
    public Loc(String voiture, String client, String date, int duree, Double prix) {
        this.voiture = voiture;
        this.client = client;
        this.date = date;
        this.duree = duree;
        this.prix = prix;
    }

    public String getVoiture() {
        return voiture;
    }

    public void setVoiture(String voiture) {
        this.voiture = voiture;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
}