
package model;


public class ContaPoupanca extends Conta {
    
    public ContaPoupanca(double saldo, String titular) {
        super(saldo, titular);
    }
    
    @Override
    public void depositar(double valor){
        this.saldo += valor;
    }
    
    @Override
    public double sacar(double valor){
        if(this.saldo - valor > 0){
            double aumento = 0.5 * this.saldo;
            double saque = this.saldo + aumento;
            return saque;
        }
        return 0;
    }
}
