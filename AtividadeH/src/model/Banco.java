
package model;


public class Banco {
    Caixa caixa = new Caixa();
    Conta []contas = new Conta[10];
    
    public void criar_contaCa_In(int op,double saldo, String titular,int senha, boolean da_ta, String data){
        if(op == 1){
            ContaCapital conta = new ContaCapital(saldo, titular,senha, da_ta, data);
        }
        if(op == 2){
            ContaInvestimento conta = new ContaInvestimento(saldo, titular,senha, da_ta, data);
        }
    }
    
    public void criar_contaPo(double saldo, String titular, int senha, boolean data){
        ContaPoupanca conta = new ContaPoupanca(saldo,titular,senha, data);
    }
    
    public void criar_contaCo_Di(int op,double saldo, String titular,int senha,boolean data, double limite){
        if(op == 3){
            ContaCorrente conta = new ContaCorrente(saldo,titular,senha, data, limite);
        }
        if(op == 4){
            ContaDigital conta = new ContaDigital(saldo,titular,senha,data, limite);
        } 
    }
    
    /*public void criar_contaIn(double saldo, String titular, String data){
        
    }*/
    
    /*public void criar_contaDi(double saldo, String titular, double limite){
        
    }*/
    
    public void fechar_conta(int numero){
        for(int i = 0; i < contas.length; i++){
            if(contas[i].getNumero_conta()==numero){
                contas[i] = null;
            }
        }
    }
    
    public void depositar(int numero, double valor){
        for(int i = 0; i < contas.length; i++){
            if(contas[i].getNumero_conta()==numero){
                contas[i].depositar(valor);
            }
        }
    }
    
    public Conta[] ret_contas(){
        return this.contas;
    }
    
    public Caixa ret_caixa(){
        return this.caixa;
    }

}
