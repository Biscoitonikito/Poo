
package app;

import java.util.Scanner;
import model.Opcao;
import negocio.Intermediario;
    //
    //
    //
    //
    // SO DA UMA OLHADA EM QUAIS METODOS RETORNAM ALGO, SE TIVER UM Q RETOEN STRING PRITNTA ELE;
    // Caso va testar, explica como e que ocorre, primeiro e criado uma votacao, para se adicionar pergunta e opçoes a ela e necessario esta logado no adm, qualquer oprecao
    // Alem de votar e preciso estar nele
    //
    //

public class app {
    public static void main(String[] args) {
        
        Intermediario negocio = new Intermediario();
        //Pra criar a votação ele precisa de uma String nome, e esse metodo tambem retorna uma String para printa, ele retorna o nome e a senha do adm
            System.out.println("Titulo da Votação");
            String nomeTitulo;
            Scanner name = new Scanner(System.in);
            nomeTitulo = name.next();
            System.out.println(negocio.criarVotacao(nomeTitulo));
        
            while(true == true){
            
            
                //Tem de ter duas areas uma pro adm e uma pra pessoas
                System.out.println("Como deseja acessar votação:/n 1 - Pessoa Normal\n 2 - Administrador");
                int Tpessoa;
                Scanner pessoa = new Scanner(System.in);
                Tpessoa = pessoa.nextInt();
            
                
                //Entrandp como pessoa normal
                if(Tpessoa == 1){
                    //Digita o token e verifica se ele esta na lista
                    if(negocio.validaToken(token) == true){
                        //Primeiro For vai printa pergunta apos pergunta
                        for(int i = 0; i < negocio.getVotacao().getListaPergunta().size(); i++){
                            //Printando pergunta
                            System.out.println((i+1) + " - " + negocio.getVotacao().getListaPergunta().get(i).getEscopo()); 
                            
                            //Segundo For vai printa todas as opções
                            for(int j = 0; j < negocio.getVotacao().getListaPergunta().get(i).getListaOpcao().size(); j++){
                                System.out.println((j+1) + " - " + negocio.getVotacao().getListaPergunta().get(i).getListaOpcao().get(j).getOpcapEscopo());
                            }
                            //Logo apoes a pessoa deve digitar em q opcao vai marcar
                            //tem de receber um valor aki para o segundo parametro do metodo abaixo
                            negocio.votar(i, aki);
                        }
                                  
                    }
                        
                }
                
                //Entrnado como adm
                if(Tpessoa == 2){
                    System.out.println("Digite a senha do ADM");
                    int senha;
                    Scanner senhaadm = new Scanner(System.in);
                    senha = senhaadm.nextInt();
                    
                    //Verificando se a pessoa possui a senha do ADM
                    if(negocio.getVotacao().getSenhaAdm() == senha){
                        int continua = 1;
                        //Aqui ele tem opções de modificar tudo
                        while(continua == 1){
                            System.out.println("Aqui voce pode:\n 1 - Adicionar Perguntas\n 2 - Remover Pergunta \n 3 - Alterar Pergunta"
                                + "\n 4 - Adiciona Opções\n 5 - Remover Opções\n 6 - Alterar Opção\n 7 - Abrir ou Fechar votação\n 8 - Apuração ");
                        
                            int escolha;
                            Scanner escolhaA = new Scanner(System.in);
                            escolha = escolhaA.nextInt();
                        
                            if(escolha == 1){
                                int cria = 1;
                                
                                //pedir o escopo da pergunta e se é obrigatoria ou não
                                negocio.criarPergunta(nomeTitulo, true);
                                
                                while(cria == 1){
                                    //digitar a opcao
                                    negocio.criarOpcao(nomeTitulo);
                                    //pergunta se vai continua - Se sim digite 1 (cria = 1), Se não digite qualquer outra tecla numerica
                                }
                                
                            }
                        
                            if(escolha == 2){
                                //Printando pergunta
                                for(int i = 0; i < negocio.getVotacao().getListaPergunta().size(); i++){
                                    System.out.println((i+1) + " - " + negocio.getVotacao().getListaPergunta().get(i).getEscopo());
                                }
                                //Digitar o numero da pergunta que vai ser deletada
                                negocio.getVotacao().getListaPergunta().remove(deleta-1);
                            }
                        
                            if(escolha == 3){
                                //Implementação não concluida
                            }
                        
                            if(escolha == 4){
                                //Cria a opção passando string
                                Opcao opcao = new Opcao(escopo);
                                
                                //vai mostra as perguntas
                                for(int i = 0; i < negocio.getVotacao().getListaPergunta().size(); i++){
                                    System.out.println((i+1) + " - " + negocio.getVotacao().getListaPergunta().get(i).getEscopo());
                                }
                                //Digitar o numero da pergunta onde a opcao vai ser adicionada passando o numero dela
                                negocio.getVotacao().getListaPergunta().get(adiciona-1);
                            }
                        
                            if(escolha == 5){
                                //Implementação incompleta
                            }
                        
                            if(escolha == 6){
                                //Implementação incompleta
                            }
                            
                            if(escolha == 7){
                                negocio.op_clo();
                            }
                            
                            if(escolha == 8){
                                //Printando a apuração
                                int [] votos;
                                for(int i = 0; i < negocio.getVotacao().getListaPergunta().size(); i++){
                                    System.out.println((i+1) + " - " + negocio.getVotacao().getListaPergunta().get(i).getEscopo());
                                    votos = negocio.getVotacao().apuracao(i);
                                    
                                    for(int j = 0; j < negocio.getVotacao().getListaPergunta().get(i).getListaOpcao().size(); j++){
                                        System.out.println((j+1) + " - " + negocio.getVotacao().getListaPergunta().get(i).getListaOpcao().get(j).getOpcapEscopo() + " - Recebeu: " + votos[j] + " voto(s)");
                                    }
                                }
                            }
                        }
                    }
                }
            
        }
        
    }
    
}
