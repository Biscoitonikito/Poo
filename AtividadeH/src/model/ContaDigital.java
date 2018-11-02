
package model;

public class ContaDigital {
    ContaCorrente conta;
    
    ContaDigital(double saldo, String titular, double limite){
        this.conta = new ContaCorrente(saldo,titular, limite);
    }
    
    public void depositar(double valor){
        conta.depositar(valor);
    }
    
    
}
