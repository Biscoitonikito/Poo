
package model;

import java.util.ArrayList;

public class Pergunta {
    private String Escopo;
    boolean obrigatoria;
    private ArrayList <Opcao> listaOpcao;
    
    public Pergunta(String escopo, boolean tipo){
        this.obrigatoria = tipo;
        this.Escopo = escopo;
        this.listaOpcao = new ArrayList<Opcao>(5);
    }
    
    public void criarPergunta(Opcao opcao){
        this.listaOpcao.add(opcao);
    }

    public String getEscopo() {
        return Escopo;
    }

    public ArrayList<Opcao> getListaOpcao() {
        return listaOpcao;
    }

    
    
}
