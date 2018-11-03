
package model;

public class ContaDigital {
    ContaCorrente conta;
    
    ContaDigital(double saldo, String titular,int senha, double limite){
        this.conta = new ContaCorrente(saldo,titular,senha, limite);
    }
    
    public void depositar(double valor){
        conta.depositar(valor);
    }
    
    
}
