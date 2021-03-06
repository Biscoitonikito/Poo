/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

public class Cartao {

    private String titulo;
    private String descricao;
    private ArrayList <Etiqueta> etiquetas;
    private ArrayList <String> comentarios;
    private boolean checkavel;
    private CheckList check;
    private boolean arquivada;
    
    Cartao(String titulo, String descricao){
        this.titulo = titulo;
        this.descricao = descricao;
        this.etiquetas = new ArrayList<Etiqueta>();
        this.comentarios = new ArrayList<String>();
        this.checkavel = false;
        this.arquivada = false;
    }
    
    public String status(){
        String status = "  "+ this.titulo + " - Descrição: " + this.descricao + "\nEtiquetas:";
        for(int i = 0; i < this.etiquetas.size(); i++){
            status += "\n   " + (i+1) + " - " + this.etiquetas.get(i).getConteudo() +" '" +  this.etiquetas.get(i).getCor() + "' ";
        }
        return status;
    }
    
    public void setArquivada() {
        this.arquivada = !this.arquivada;
    
    }
    
    public void criarCheck(){
        this.check = new CheckList();
        this.checkavel = true;
    }
    
    public void fecharCheck(){
        this.checkavel = false;
        this.check = null;
    }
    
    public void criarOpcao(String titulo){
        if(this.checkavel == true){
            this.check.criarOpcao(titulo);
        }
    }
    
    public void removerOpcao(int i){
        if(this.checkavel == true){
            this.check.removerOpcao(i);
        }
    }
    
    public void marca(int i){
        if(this.checkavel == true){
            this.check.marca(i);
        }
    }
    
    public void criarEtiqueta(String cor, String conteudo){
        Etiqueta etiqueta = new Etiqueta(cor, conteudo);  
    }
    
    public void removerEtiqueta(int i){
        this.etiquetas.remove(i);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Etiqueta getEtiquetas(int i) {
        return this.etiquetas.get(i);
    }

    public String getComentarios(int i) {
        return this.comentarios.get(i);
    }

    public boolean isArquivada() {
        return arquivada;
    }
  
}
