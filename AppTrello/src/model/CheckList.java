
package model;

import java.util.ArrayList;


public class CheckList {
    private ArrayList <Opcao> listaOpcao = new ArrayList<Opcao>();
    
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
}
