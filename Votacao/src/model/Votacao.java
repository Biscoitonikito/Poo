
package model;

import java.util.ArrayList;
import java.util.Random;

public class Votacao {
    private String nome;
    private int senhaAdm;
    private boolean ativa;
    private ArrayList <Pergunta> listaPergunta;
    private ArrayList <Token> listaToken;
    private Random gerador = new Random();
    
    
    public Votacao(String nome){
        this.nome = nome;
        this.ativa = false;
        this.listaPergunta = new ArrayList<Pergunta>();
        this.listaToken = listaToken  = new ArrayList<Token>();
        int senha = gerador.nextInt(1000)+1;
        this.senhaAdm = senha;
    }
    
    public String status(){
        return "Título da Votação: " + this.nome + "\nSenha do Administrador: " + this.senhaAdm;
    }
    
    public void openClose(){
        if(this.ativa == false){
            this.ativa = true;
        }
        else{
            this.ativa = false;
        }
    }
    
    public void criarPergunta(String escopo, boolean tipo){
        if(this.ativa == false){
            Pergunta pergunta = new Pergunta(escopo,tipo);
            this.listaPergunta.add(pergunta);
        }
    }
    
    public void removerPergunta(int i){
        if(this.ativa == false){
            this.listaPergunta.remove(i);
        }
    }
    
    /*public void alteraPergunta(String escopo, boolean tipo, int i){
        Pergunta pergunta = new Pergunta(escopo,tipo);
        this.listaPergunta.add(i, pergunta);
        
    }*/
    
    public void returnPergunta(int i){
        this.listaPergunta.get(i);
    }
    
    public ArrayList <Pergunta> getListaPergunta() {
        return listaPergunta;
    }
    
    public void gerarTokens(){
        for(int i = 0 ; i<this.listaToken.size(); i++){
            int tokens = gerador.nextInt(1000)+1;
            Token token = new Token(tokens);
            this.listaToken.add(token);
        }
    }

    public ArrayList <Token> getListaToken() {
        return listaToken;
    }
    
    public boolean validaToken(int token){
        for(int i = 0; i < this.listaToken.size(); i++){
            if(this.listaToken.get(i).getNumero() == token && this.listaToken.get(i).isUtilizado() == false){
                return true;
            }
        }
        return false;
    }
    public void marca(int i, int j){
        this.listaPergunta.get(i).marca(j);
    }

    public boolean isAtiva() {
        return ativa;
    }

    public String getNome() {
        return nome;
    }

    public int getSenhaAdm() {
        return senhaAdm;
    }
    
    public int [] apuracao(int i){
        return this.listaPergunta.get(i).returnQuantia();
    }
    
}
