
package model;

import java.util.ArrayList;

public class Votacao {
    private String nome;
    private boolean ativa;
    private ArrayList <Pergunta> listaPergunta;
    private ArrayList <Token> listaToken;
    
    
    public Votacao(String nome, int perguntas, int tokens){
        this.nome = nome;
        this.ativa = false;
        this.listaPergunta = new ArrayList<Pergunta>(perguntas);
        this.listaToken = listaToken  = new ArrayList<Token>(tokens);
    }
    
    public void openClose(){
        if(this.ativa == false){
            this.ativa = true;
        }
        else{
            this.ativa = false;
        }
    }
    
    public ArrayList <Pergunta> getListaPergunta() {
        return listaPergunta;
    }

    public ArrayList <Token> getListaToken() {
        return listaToken;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public String getNome() {
        return nome;
    }
    
    
}
