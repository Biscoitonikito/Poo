
package negocio;

import java.util.ArrayList;
import java.util.Random;
import model.Votacao;
import model.Opcao;
import model.Pergunta;
import model.Token;

public class intermediario {

    private Votacao votacao;
    private Random gerador = new Random();
    
    public String votar(int token, int i, int j){
        for(int x = 0; x < this.votacao.getListaToken().size(); x++){
            if(this.votacao.getListaToken().get(x).getNumero() == token){
                if(this.votacao.getListaToken().get(x).isUtilizado() != true){
                    marca(i,j);
                }
            }
        }
        return null;
    }
    
    public String marca(int i, int j){
        if(i > 0 && i < this.votacao.getListaPergunta().size() ){
            if(j>0 && j<6){
                this.votacao.getListaPergunta().get(i).getListaOpcao().get(j-1).aumentaContador();
                return "Voto confirmado";
            }
            if(j == 6){
                return "Voto Branco";
            }
        }
        return null;
    }
    
    public void criarVotacao(String nome, int perguntas, int tokens){
      votacao = new Votacao(nome,perguntas,tokens);
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
    public ArrayList <Token> getToken(){
        return this.votacao.getListaToken();
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
    }

}
