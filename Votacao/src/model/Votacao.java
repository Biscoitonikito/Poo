
package model;

import java.util.ArrayList;
import java.util.Random;

public class Votacao {
    private String nome;
    private boolean ativa = false;
    private ArrayList <Pergunta> listaPergunta = new ArrayList();
    private int []listaTokens;
    private Random gerador = new Random();
    
    
    public int[] gerarTokens(){
        for(int i = 0 ; i<this.listaTokens.length; i++){
            this.listaTokens[i] = gerador.nextInt(200);
        }
        return this.listaTokens;
    }
    
    public void openClose(){
        if(this.ativa == false){
            this.ativa = true;
        }
        else{
            this.ativa = false;
        }
    }
                
    public void apuracao(){
        int [][] apuracao = new int[this.listaPergunta.size()][];
        
        for(int i = 0; i < this.listaPergunta.size(); i++){
            ArrayList <Opcao> listaOpcao =this.listaPergunta.get(i).getListaOpcao();
            for(int j = 0 ; j < listaOpcao.size(); j++){
                listaOpcao.get(j).getContador();
            }
        }
    }
    
}
