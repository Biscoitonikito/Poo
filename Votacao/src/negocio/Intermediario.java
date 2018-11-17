
package negocio;

import java.util.ArrayList;
import java.util.Random;
import model.Votacao;
import model.Opcao;
import model.Pergunta;
import model.Token;

public class Intermediario {
    private Votacao votacao;
    
    public Intermediario(){
        
    }
       
    public String criarVotacao(String nome){
        this.votacao = new Votacao(nome);
        return this.votacao.status();
    }
    
    public void criarPergunta(String escopo, boolean tipo){
        this.votacao.criarPergunta(escopo, tipo);   
    }
    
    public void criarOpcao(String escopo){
        this.votacao.getListaPergunta().get(this.votacao.getListaPergunta().size()-1).criarOpcao(escopo);
    }
    
    public String votar(int i, int j){
        this.votacao.marca(i,j);
        return "Voto efetuado";
    }
    
    public boolean validaToken(int i){
        if(this.votacao.validaToken(i)==true){
            return true;
        }
        return false;
    }
    
    /*public String modificarVoto(int token, int i, int j){
        for(int x = 0; x < this.votacao.getListaToken().size(); x++){
            if(this.votacao.getListaToken().get(x).getNumero() == token){
                if(this.votacao.getListaToken().get(x).isUtilizado() == true){
                    this.votacao.marca(i,j);
                    return "Voto modificado";
                }
            }
        }
        return "Não houve como modificar o voto";
    }*/
    
    
    
    public void op_clo(){
        this.votacao.openClose();
    }
    
    
    /*public String marca(int i, int j){
        if(i > 0 && i < this.votacao.getListaPergunta().size() ){
            if(j>0 && j<this.votacao.getListaPergunta().get(i).getListaOpcao().size()){
                this.votacao.getListaPergunta().get(i).marca(j);
                return "Voto confirmado";
            }
            else{
                return "Voto Branco";
            }
        }
        return null;
    }
    
    
    
    public void criarVotacao(String nome){
        int senha = gerador.nextInt(1000);
        votacao = new Votacao(nome);
    }
    
    public void criarPergunta(String escopo, boolean tipo){
        Pergunta pergunta = new Pergunta(escopo,tipo);
        this.votacao.getListaPergunta().add(pergunta);
    }
    
    public void criarOpcao(String escopo, int i){
        if(!votacao.getListaPergunta().isEmpty()){
            for(int j = 0; j < votacao.getListaPergunta().size(); j++){
                this.votacao.getListaPergunta().get(j);
                if(i == 1){
                    Opcao opcao = new Opcao(escopo);
                    this.votacao.getListaPergunta().get(j).criarPergunta(opcao);
                }
                if(i == 2){
                    Opcao opcao = new Opcao();
                    this.votacao.getListaPergunta().get(j).criarPergunta(opcao);
                }
            }
        }
        
    }
    
    public void gerarTokens(){
        for(int i = 0 ; i<this.votacao.getListaToken().size(); i++){
            int a = gerador.nextInt(300);
            Token token = new Token(a);
            this.votacao.getListaToken().add(token);
        }
    }
    
    public int [][] apuracao(){
        int [][] apuracao = new int[this.votacao.getListaToken().size()][this.votacao.getListaPergunta().get(0).getListaOpcao().size()];
        
        for(int i = 0; i < this.votacao.getListaPergunta().size(); i++){
            for(int j = 0 ; j < this.votacao.getListaPergunta().get(i).getListaOpcao().size(); j++){
                apuracao[i][j] = this.votacao.getListaPergunta().get(0).getListaOpcao().get(j).getContador();
            }
        }
        
        return apuracao;
    }*/

    public Votacao getVotacao() {
        return votacao;
    }

}
