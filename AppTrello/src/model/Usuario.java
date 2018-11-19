
package model;

import java.util.ArrayList;

public class Usuario {
    Perfil perfil;
    private ArrayList <Quadro> listaQuadros;
    
    private ArrayList <Time> Times;

    
    Usuario(String nome,String login, int senha){
        this.perfil = new Perfil(nome,login,senha);
        this.listaQuadros = new ArrayList<Quadro>();
        this.listaCartoes 
        this.Times = new ArrayList<Time>();
    }
    
    Cartoes buscarCard(String titulo){
        for(int i = 0; i < this.listaQuadros.size(); i++){
            if(this.listaCartoes.get(i).getTitulo() == titulo){
                return this.listaCartoes.get(i);
            }
        }
        return null;
    }
    
    Quadro
    
    void criarquadro(){
        
    }
    
    void mostraquadros(){
        
    }
    
    void criatime(){
        
    }
    
    void mostratime(){
        
    }
    
    
    
    
}
