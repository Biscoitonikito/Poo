package com.example.guilherme.atividadex.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Logado {
    @Id
    private long id;
    private long idLogado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdLogado() {
        return idLogado;
    }

    public void setIdLogado(long idLogado) {
        this.idLogado = idLogado;
    }
}
