
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
                System.out.print("Digite o numero da sua conta\n");
                int numero_conta;
                Scanner conta_numero = new Scanner(System.in);
                numero_conta = conta_numero.nextInt();
                System.out.print("Digite o numero da sua conta\n");
                int senha_conta;
                Scanner conta_senha = new Scanner(System.in);
                senha_conta = conta_senha.nextInt();
                
                for(int i = 0; i < contas.length; i++){
                    int cont = 1;
                    if(contas[i].getNumero_conta() == numero_conta && contas[i].getSenha() == senha_conta){
                        while(cont == 1){
                            
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
                        }
                    }
                    else{
                        System.out.println("Dados incorretos\n");
                    }
                }
                
                
            }
            
            
        }
    }
}
