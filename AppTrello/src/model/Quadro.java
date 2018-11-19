
package model;

import java.util.ArrayList;


public class Quadro {
    String titulo;
    String visibilidade;
    ArrayList <Lista> Listas;
    
    Quadro(String titulo, int i){
        this.titulo = titulo;
        if(i == 1){
            this.visibilidade = "Privado";
        }
        if(i == 2){
            this.visibilidade = "Visivel para o Time";
        }
        if(i == 3){
            this.visibilidade = "Publico";
        }
        this.Listas = new ArrayList<Lista>();
    }
    
            
    void deletarLista(){
        
    }
    
    void mover(){
        
    }
    
    void copiar(){
        
    }

    public String getTitulo() {
        return titulo;
    }

}
