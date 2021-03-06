
package model;

import java.util.ArrayList;


public class Quadro {
    private String titulo;
    private String visibilidade;
    private boolean favorito;
    private boolean fechado;
    private ArrayList <Lista> Listas;
    
    Quadro(String titulo){
        this.titulo = titulo;
        this.visibilidade = "Privado";
        this.fechado = false;
        this.favorito = false;
        this.Listas = new ArrayList<Lista>();
    }
    
    public void criarLista(String nome){
        Lista lista = new Lista(nome);
        this.Listas.add(lista);
    }
    public void deletarLista(int i){
        if(this.Listas.get(i).isArquivada() == true){
            this.Listas.remove(i);
        }
    }
    
    public void arquivaLista(int i){
        this.Listas.get(i).setArquivada();
    }

    public void copiarLista(int i){
        if(this.Listas.get(i).isArquivada() == false){
            this.Listas.add(this.Listas.get(i));
        }
    }
    
    void mover(){
        //Complemento depois
    }
    
    public int getSize(){
        return this.Listas.size();
    }
    public Lista getLista(int i) {
        return this.Listas.get(i);
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getVisibilidade() {
        return visibilidade;
    }
 
    public void setVisibilidade(int i) {
        if(i == 1){
            this.visibilidade = "Privado";
        }
        if(i == 2){
            this.visibilidade = "Visivel para o Time";
        }
        if(i == 3){
            this.visibilidade = "Publico";
        }
    }

    public void setFavorito() {
        this.favorito = !this.favorito;
    }

    public boolean isFavorito() {
        return favorito;
    }
    
    public void setFechado(){
        this.fechado = !this.fechado;
    }

    public boolean isFechado() {
        return fechado;
    }
    
    
}
