
package model;

public class ContaCorrente extends Conta {
    double limite;
    
    public ContaCorrente(double saldo, String titular,int senha, double limite) {
        super(saldo, titular,senha);
        this.limite = limite;
    }
    
    @Override
    public void depositar(double valor){
       this.saldo += valor; 
    }
    
    @Override
    public double sacar(double valor){
        if(this.saldo - valor > limite){
            double aumento = 0.6 * this.saldo;
            double saque = this.saldo + aumento;
            return saque;
        }
        return 0;
    }
    
}
