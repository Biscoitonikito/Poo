
package model;

import java.util.ArrayList;


public class Lista {
    private String titulo;
    private boolean arquivada;
    private ArrayList <Cartao> listaCartoes;

    
    Lista(String titulo){
        this.titulo = titulo;
        this.arquivada = false;
        this.listaCartoes = new ArrayList<Cartao>();
    }
    
    public void criarCartao(String nome, String descricao){
        Cartao cartao = new Cartao(nome,descricao);
        this.listaCartoes.add(cartao);
    }
    
    public void mover(){
        //Complemento depois
    }
    
    public void removerCartao(int i){
        if(this.listaCartoes.get(i).isArquivada() == true){
            this.listaCartoes.remove(i);
        }
    }
    
    public void copiarCartao(int i){
        if(this.listaCartoes.get(i).isArquivada() == false){
            this.listaCartoes.add(this.listaCartoes.get(i));
        }
    }
    
    public void arquivaCartao(int i){
        this.listaCartoes.get(i).setArquivada();
    }
    
    public Cartao buscaCartao(String nome) {
        for(int i = 0; i < this.listaCartoes.size(); i++){
            if(this.listaCartoes.get(i).getTitulo() == titulo && this.listaCartoes.get(i).isArquivada() == false){
                return this.listaCartoes.get(i);
            }
        }
        return null;
    }
    
    public Cartao getCartao(int i) {
        return this.listaCartoes.get(i);
    }
    
    public void setArquivada() {
        if(this.arquivada == false){
            this.arquivada = true;
        }
        else{
            this.arquivada = false;
        }
    
    }
    
    public boolean isArquivada() {
        return arquivada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public int getSize(){
        return this.listaCartoes.size();
    }
}
