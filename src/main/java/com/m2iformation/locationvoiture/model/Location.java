package com.m2iformation.locationvoiture.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Location {

    @EmbeddedId
    private Locationkey id;

    @ManyToOne
    @MapsId("voitureId")
    @JoinColumn(name="voiture_id")
    private Voiture voiture;


    @ManyToOne
    @MapsId("clientId")
    @JoinColumn(name="client_id")
    private Client client;

    private LocalDateTime date;

    private int duree; // en jour

    private Double prix;


    public Locationkey getId() {
        return id;
    }

    public void setId(Locationkey id) {
        this.id = id;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
