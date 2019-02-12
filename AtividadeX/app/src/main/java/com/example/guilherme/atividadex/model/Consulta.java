package com.example.guilherme.atividadex.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

//Não houve tempo de implementa-la por completo;
@Entity
public class Consulta {
    @Id
    private long id;
    private String endereco;
    private String hospital;
    private String medico;
    private String data;
    private String hora;
    private long idUsuario;

    public Consulta() {
    }

    public Consulta(String endereco, String hospital, String medico, String data, String hora, long idUsuario) {
        this.endereco = endereco;
        this.hospital = hospital;
        this.medico = medico;
        this.data = data;
        this.hora = hora;
        this.idUsuario = idUsuario;
    }

    public void atualizaDados(String endereco, String hospital, String medico, String data, String hora){
        this.endereco = endereco;
        this.hospital = hospital;
        this.medico = medico;
        this.data = data;
        this.hora = hora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
