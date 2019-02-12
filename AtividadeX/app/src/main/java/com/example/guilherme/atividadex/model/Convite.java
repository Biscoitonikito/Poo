package com.example.guilherme.atividadex.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Convite {
    @Id
    private long id;
    private long idUsuarioOne;
    private long idUsuarioTwo;
    private String conteudo;

    Convite(){

    }

    public Convite(long idUsuarioOne, long idUsuarioTwo, String conteudo) {
        this.idUsuarioOne = idUsuarioOne;
        this.idUsuarioTwo = idUsuarioTwo;
        this.conteudo = conteudo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUsuarioOne() {
        return idUsuarioOne;
    }

    public void setIdUsuarioOne(long idUsuarioOne) {
        this.idUsuarioOne = idUsuarioOne;
    }

    public long getIdUsuarioTwo() {
        return idUsuarioTwo;
    }

    public void setIdUsuarioTwo(long idUsuarioTwo) {
        this.idUsuarioTwo = idUsuarioTwo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
