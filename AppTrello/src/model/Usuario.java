
package model;

import java.util.ArrayList;

public class Usuario {
    Perfil perfil;
    private ArrayList <Quadro> listaQuadros;
    private ArrayList <Cartoes> listaCartoes;
    private ArrayList <Time> Times;

    
    Usuario(String login, int senha){
        this.perfil = new Perfil(login,senha);
        this.listaQuadros = new ArrayList<Quadro>();
        this.listaCartoes = new ArrayList<Cartoes>();
        this.Times = new ArrayList<Time>();
    }
    
    void buscar(){
        
    }
    
    void criarquadro(){
        
    }
    
    void mostraquadros(){
        
    }
    
    void criatime(){
        
    }
    
    void mostratime(){
        
    }
    
    
    
    
}
