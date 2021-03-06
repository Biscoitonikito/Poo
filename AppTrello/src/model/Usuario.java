
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Usuario {
    private Perfil perfil;
    private ArrayList <Quadro> listaQuadros;
    //private ArrayList <Time> Times;

    
    public Usuario(String nome,String login, int senha){
        this.perfil = new Perfil(nome,login,senha);
        this.listaQuadros = new ArrayList<Quadro>();
        //this.Times = new ArrayList<Time>();
    }
    
    public int getSize(){
        return this.listaQuadros.size();
    }
    
    public Quadro buscaQuadro(String nome) {
        for(int i = 0; i < this.listaQuadros.size(); i++){
            if(this.listaQuadros.get(i).getTitulo() == nome){
                return this.listaQuadros.get(i);
            }
        }
        return null;
    }
    
    public Quadro getQuadro(int i){
        return this.listaQuadros.get(i);
    }
    
    public void criarQuadro(String titulo){
        Quadro quadro = new Quadro(titulo);
        this.listaQuadros.add(quadro);
    }
    
    public void removerQuadro(int i){
        if(this.listaQuadros.get(i).isFechado() == true){
            this.listaQuadros.remove(i);
        }
    }
    
    public void fecharQuadro(int i){
        this.listaQuadros.get(i).setFechado();
    }
    
    public void copiarQuadro(int i){
        if(this.listaQuadros.get(i).isFechado() == false){
            this.listaQuadros.add(this.listaQuadros.get(i));
        }
    }

    public Perfil getPerfil() {
        return perfil;
    }

}
