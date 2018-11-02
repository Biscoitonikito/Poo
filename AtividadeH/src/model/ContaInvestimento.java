
package model;

public class ContaInvestimento extends ContaCapital {
    private String data;

    public ContaInvestimento(double saldo, String titular, String data) {
        super(saldo, titular, data);  
    }
    
    @Override
    public void depositar(double valor){
        this.saldo += valor;
    }
    
    @Override
    public double sacar(double valor){
        if(this.saldo - valor > 0){
            double aumento = 0.7 * this.saldo;
            double saque = this.saldo + aumento;
            saque -= 100;
            return saque;
        }
        return 0;
    }

}
