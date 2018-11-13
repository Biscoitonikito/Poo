
package model;

import java.util.ArrayList;

class Pergunta {
    private String Escopo;
    private ArrayList <Opcao> listaOpcao = new ArrayList();
    
    Pergunta(String escopo){
        this.Escopo = escopo;
    }

    public String getEscopo() {
        return Escopo;
    }

    public ArrayList<Opcao> getListaOpcao() {
        return listaOpcao;
    }

    public void marca(int i){
        if(i > 0 && i < 6){
            this.listaOpcao.get(i-1).aumentaContador();
            this.listaOpcao.get(i-1).setMarcado();
        }
    }
    
}
