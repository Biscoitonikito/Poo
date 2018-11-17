
package model;

import java.util.ArrayList;

public class Pergunta {
    private String Escopo;
    private boolean obrigatoria;
    private int[]quantia = new int[this.listaOpcao.size()];
    private ArrayList <Opcao> listaOpcao = new ArrayList<Opcao>();
    
    public Pergunta(String escopo, boolean tipo){
        this.Escopo = escopo;
        this.obrigatoria = tipo;
    }
    
    /*public void criarOpcao(String escopo, int i){
        if(i == 1){
            Opcao opcao = new Opcao(escopo);
            this.listaOpcao.add(opcao);
            }
        
        if(i == 2){
            Opcao opcao = new Opcao();
            this.listaOpcao.add(opcao);
        }
    }*/
    
    public void criarOpcao(String escopo){
        Opcao opcao = new Opcao(escopo);
        this.listaOpcao.add(opcao);
    }
    
    public void retirarOpcao(int num){
        this.listaOpcao.remove(num);
    }
    
    /*public void modificarOpcao(int num, String escopo){
        Opcao opcao = new Opcao(escopo);
        this.listaOpcao.add(num, opcao);
    }*/
    
    public void marca(int i){
        for(int j = 0; j < this.listaOpcao.size(); j++){
            if(this.listaOpcao.get(j).isMarcado() == true){
                this.listaOpcao.get(j).setMarcado();
                
            }
        }
        this.listaOpcao.get(i).setMarcado();
    }

    public String getEscopo() {
        return Escopo;
    }

    public boolean isObrigatoria() {
        return obrigatoria;
    }

    public ArrayList<Opcao> getListaOpcao() {
        return listaOpcao;
    }
    
    public Opcao retornOpcao(int i){
        return this.listaOpcao.get(i);
    }
    
    public  int [] returnQuantia(){
        return this.quantia;
    }
    
    public void atualiza(){
        if(this.listaOpcao.isEmpty() == false){
            for(int i = 0; i < this.listaOpcao.size(); i++){
                this.quantia[i] = this.listaOpcao.get(i).getContador();
            }
        }
    }
}
