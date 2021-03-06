package com.example.guilherme.teste;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;


@Entity
public class Usuario {

    @Id
    private long id;
    private String email;
    private String senha;

    public Usuario() {
    }

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
}
