
package model;

import java.util.ArrayList;


public class CheckList {
    private ArrayList <Opcao> listaOpcao;
    
    CheckList(){
        this.listaOpcao = new ArrayList<Opcao>();
    }
    
    public void marca(int i){
        for(int j = 0; j < this.listaOpcao.size(); j++){
            if(this.listaOpcao.get(j).isMarcado() == true){
                this.listaOpcao.get(j).setMarcado();
                
            }
        }
        this.listaOpcao.get(i).setMarcado();
    }

    public ArrayList<Opcao> getListaOpcao() {
        return listaOpcao;
    }
    
    public void criarOpcao(String escopo){
        Opcao opcao = new Opcao(escopo);
        this.listaOpcao.add(opcao);
    }
    
    public void removerOpcao(int i){
        this.listaOpcao.remove(i);
    }
}
