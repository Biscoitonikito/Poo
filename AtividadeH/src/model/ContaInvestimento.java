
package model;

public class ContaInvestimento extends Conta {
    private String data;

    public ContaInvestimento(double saldo, String titular,int senha,boolean da_ta, String data) {
        super(saldo, titular,senha,da_ta);  
        this.data =data;
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
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
