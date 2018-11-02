
package model;

public class Conta {
    private double saldo;
    private String titular;
    private int numero_conta = (int) Math.random();

    public Conta(double saldo, String titular) {
        this.saldo = saldo;
        this.titular = titular;
    }
    
    public void sacar(){
        
    }
    
    public void depositar(){
        
    }
    
    public int getNumero_conta() {
        return numero_conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }
    
    
    
    
    
    
    
    
}
