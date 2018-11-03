
package model;

public class Conta {
    protected double saldo;
    protected String titular;
    protected int senha;
    boolean data;
    protected int numero_conta = (int) Math.random();

    public Conta(double saldo, String titular, int senha, boolean data) {
        this.saldo = saldo;
        this.titular = titular;
        this.senha = senha;
        this.data = data;
    }
    public Conta isConta(int numero, Conta []conta){
        for(int i = 0; i< conta.length;i++){
            if(conta[i].getNumero_conta() == numero){
                return conta[i];
            }
        }
        return null;
    }
    public double sacar(double valor){
        return 0;       
    }
    
    public void depositar(double valor){
        
    }
    
    public String status(){
        return "Titular: " + this.titular + "\nSaldo: "+ this.saldo + "\nNº Conta: "+ this.numero_conta;
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

    public int getSenha() {
        return senha;
    }

    public boolean isData() {
        return data;
    }

}
