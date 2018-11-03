
package app;

import java.util.Scanner;
import model.Banco;
import model.Caixa;
import model.Conta;
import model.ContaCapital;

public class app {
    public static void main(String[] args){
        Banco banco = new Banco();
        Conta[] contas = banco.ret_contas();
        Caixa caixa = banco.ret_caixa();
        
        while(true == true){
            System.out.print("O que você deseja?\n1 - Ir para os caixas\n2 - Criar Conta\n3 - Deposita via envelope\n");
            int opcao1;
            Scanner escolha1 = new Scanner(System.in);
            opcao1 = escolha1.nextInt();
            if(opcao1 == 1){
                boolean logado;
                System.out.print("Digite o numero da sua conta\n");
                int numero_conta;
                Scanner conta_numero = new Scanner(System.in);
                numero_conta = conta_numero.nextInt();
                System.out.print("Digite a senha da sua conta\n");
                int senha_conta;
                Scanner conta_senha = new Scanner(System.in);
                senha_conta = conta_senha.nextInt();
                
                for(int i = 0; i < contas.length; i++){
                    int cont = 1;
                    if(contas[i].getNumero_conta() == numero_conta && contas[i].getSenha() == senha_conta){
                        do{
                            
                            System.out.println("Qual opção você quer realizar:\n1 - Depositar\n2 - Sacar\n");
                            int opcaoC;
                            Scanner escolhaC = new Scanner(System.in);
                            opcaoC = escolhaC.nextInt();
                            
                            if(opcaoC == 1){
                                System.out.println("Qual o valor do déposito:\n");
                                int valor_deposita;
                                Scanner deposito = new Scanner(System.in);
                                valor_deposita = deposito.nextInt();
                                caixa.deposita(contas[i], valor_deposita);
                            }
                            
                            if(opcaoC == 2){
                                if (contas[i].isData() == false){
                                    System.out.println("Qual o valor do saque:\n");
                                    int valor_saca;
                                    Scanner saca = new Scanner(System.in);
                                    valor_saca = saca.nextInt();
                                    caixa.sacar(contas[i], valor_saca);
                                }
                                else{
                                    System.out.println("Digite a data de hoje:\n");
                                    String data_saca;
                                    Scanner data = new Scanner(System.in);
                                    data_saca = data.next();
                                    System.out.println("Qual o valor do saque:\n");
                                    int valor_saca;
                                    Scanner saca = new Scanner(System.in);
                                    valor_saca = saca.nextInt();
                                    caixa.sacar((ContaCapital) contas[i], valor_saca, data_saca);
                                }
                                
                            }
                            
                            System.out.println("Deseja continua na sua conta?\nDigite 1 para continuar ou qualquer outro núemro para sair");
                            int resposta;
                            Scanner a = new Scanner(System.in);
                            resposta = a.nextInt();
                            cont = resposta;
                        }while(cont == 1);
                    }
                    else{
                        System.out.println("Dados incorretos\n");
                    }
                } 
            }
            
            if(opcao1 == 2){
                
                System.out.println("Qual conta você deseja criar?\n1 - Capital\n2 - Investimento\n3 - Poupança\n4 - Corrente\n5 - Digital\n");
                int criar_conta;
                Scanner novo = new Scanner(System.in);
                criar_conta = novo.nextInt();
                
                if(criar_conta == 1 || criar_conta == 2){
                    System.out.println("Digite o seu nome:");
                    String titular;
                    Scanner titular_conta = new Scanner(System.in);
                    titular = titular_conta.next();
                    
                    System.out.println("Digite a sua senha:");
                    int senha;
                    Scanner senha_conta = new Scanner(System.in);
                    senha = senha_conta.nextInt();
                    
                    System.out.println("Digite o saldo inicial:");
                    int saldo;
                    Scanner saldo_conta = new Scanner(System.in);
                    saldo = saldo_conta.nextInt();
                    
                    System.out.println("Digite a data prevista para o saque:");
                    String data;
                    Scanner data_conta = new Scanner(System.in);
                    data = data_conta.next();
                    
                    int r;
                    System.out.println("Este é o numero da sua conta:");
                    r = banco.criar_contaCa_In(opcao1, saldo, titular, opcao1, true, data);
                    if(r == 0){
                        System.out.println("Valore inseridos estão incorretos");
                    }
                    else{
                        System.out.println(r);
                        System.out.println("Memorize ou anote pois será necessário usa-lo para acessar sua conta");
                    }
                }
                
                if(criar_conta == 3){
                    System.out.println("Digite o seu nome:");
                    String titular;
                    Scanner titular_conta = new Scanner(System.in);
                    titular = titular_conta.next();
                    
                    System.out.println("Digite a sua senha:");
                    int senha;
                    Scanner senha_conta = new Scanner(System.in);
                    senha = senha_conta.nextInt();
                    
                    System.out.println("Digite a sua saldo;");
                    int saldo;
                    Scanner saldo_conta = new Scanner(System.in);
                    saldo = saldo_conta.nextInt();
                    int r;
                    
                    System.out.println("Este é o numero da sua conta:");
                    r = banco.criar_contaPo(saldo, titular, senha, false);
                    if(r == 0){
                        System.out.println("Valore inseridos estão incorretos");
                    }
                    else{
                        System.out.println(r);
                        System.out.println("Memorize ou anote pois será necessário usa-lo para acessar sua conta");
                    }
                }
                
                if(criar_conta == 4 || criar_conta == 5){
                    System.out.println("Digite o seu nome:");
                    String titular;
                    Scanner titular_conta = new Scanner(System.in);
                    titular = titular_conta.next();
                    
                    System.out.println("Digite a sua senha:");
                    int senha;
                    Scanner senha_conta = new Scanner(System.in);
                    senha = senha_conta.nextInt();
                    
                    System.out.println("Digite a sua senha:");
                    int saldo;
                    Scanner saldo_conta = new Scanner(System.in);
                    saldo = saldo_conta.nextInt();
                    
                    System.out.println("Digite o limite:");
                    double limite;
                    Scanner limite_conta = new Scanner(System.in);
                    limite = limite_conta.nextDouble();
                    int r;
                    
                    System.out.println("Este é o numero da sua conta:");
                    r = banco.criar_contaCo_Di(opcao1, limite, titular, senha, true, limite);
                    if(r == 0){
                        System.out.println("Valore inseridos estão incorretos");
                    }
                    else{
                        System.out.println(r);
                        System.out.println("Memorize ou anote pois será necessário usa-lo para acessar sua conta");
                    }
                }
            }
            
            
        }
    }
}
