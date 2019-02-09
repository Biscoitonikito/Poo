package com.example.guilherme.atividadex.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Medicamento {
    @Id
    private long id;
    private String nome;
    private String descricao;
    private String validade;
    private int periodo;
    private int hora;
    private  int minuto;
    private boolean lembrar;
    private long idUsuario;

    public Medicamento() {}

    public Medicamento(String nome, String descricao, String validade, int periodo, int hora, int minuto, long id) {
        this.nome = nome;
        this.descricao = descricao;
        this.validade = validade;
        this.periodo = periodo;
        this.hora = hora;
        this.minuto = minuto;
        this.lembrar = false;
        this.idUsuario = id;
    }

    public void atualizaHora(){
        if(this.hora >= 24){
            this.hora = (this.hora + this.periodo) - 24;
        }
        else{
            this.hora += this.periodo;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getHora() { return hora; }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public long getIdUsuario() { return idUsuario; }

    public void setIdUsuario(long idUsuario) { this.idUsuario = idUsuario; }

    public boolean isLembrar() {
        return lembrar;
    }

    public void setLembrar() {
        this.lembrar = !lembrar;
    }
}
