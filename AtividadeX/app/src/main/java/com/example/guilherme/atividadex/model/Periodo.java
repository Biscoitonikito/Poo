package com.example.guilherme.atividadex.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Periodo {
    @Id
    private long id;
    private long idDono;
    private double periodo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdDono() {
        return idDono;
    }

    public void setIdDono(long idDono) {
        this.idDono = idDono;
    }

    public double getPeriodo() {
        return periodo;
    }

    public void setPeriodo(double periodo) {
        this.periodo = periodo;
    }
}
