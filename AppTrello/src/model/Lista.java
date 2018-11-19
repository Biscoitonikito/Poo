
package model;

import java.util.ArrayList;


public class Lista {
    private String titulo;
    private ArrayList <Cartao> listaCartoes;

    
    Lista(String titulo){
        this.titulo = titulo;
        this.listaCartoes = new ArrayList<Cartao>();
    }
    
    public void criarCartao(String nome, String descricao){
        Cartao cartao = new Cartao(nome,descricao);
        this.listaCartoes.add(cartao);
    }
    
    public void removerCartao(int i){
        this.listaCartoes.remove(i);
    }
    
    public Cartao getListaCartao(String nome) {
        for(int i = 0; i < this.listaCartoes.size(); i++){
            if(this.listaCartoes.get(i).getTitulo() == titulo){
                return this.listaCartoes.get(i);
            }
        }
        return null;
    }
}
