/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class Cartao {
    String titulo;
    String descricao;
    private ArrayList <Etiqueta> etiquetas;
    private ArrayList <String> comentarios;
    CheckList check;
    
    Cartao(String titulo, String descricao){
        this.titulo = titulo;
        this.descricao = descricao;
        this.etiquetas = new ArrayList<Etiqueta>();
        this.comentarios = new ArrayList<String>();
    }

    public String getTitulo() {
        return titulo;
    }
    
}
