package com.example.guilherme.atividadex.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Usuario {
    @Id
    private long id;
    private String email;
    private String senha;
    private String nome;
    private String endereco;
    private String telefone;
    private long idSupervisonador;
    private long idResponsavel;

    public Usuario() {
    }

    public Usuario(String email, String senha, String nome, String endereco, String telefone) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    /*public void salvar(){
        DatabaseReference reference = FireStore.getReference();
        reference.child("usuario").child(String.valueOf(getId())).setValue(this)
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public long getIdSupervisonador() {
        return idSupervisonador;
    }

    public void setIdSupervisonador(long idSupervisonador) {
        this.idSupervisonador = idSupervisonador;
    }

    public long getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(long idResponsavel) {
        this.idResponsavel = idResponsavel;
    }
}
