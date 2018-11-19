
package model;

import java.util.ArrayList;

public class Usuario {
    Perfil perfil;
    private ArrayList <Quadro> listaQuadros;
    
    private ArrayList <Time> Times;

    
    Usuario(String nome,String login, int senha){
        this.perfil = new Perfil(nome,login,senha);
        this.listaQuadros = new ArrayList<Quadro>();
        this.Times = new ArrayList<Time>();
    }
    
    
    public Quadro buscaQuadro(String nome) {
        for(int i = 0; i < this.listaQuadros.size(); i++){
            if(this.listaQuadros.get(i).getTitulo() == nome){
                return this.listaQuadros.get(i);
            }
        }
        return null;
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
