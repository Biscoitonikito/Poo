
package caelumcap4;

public class Conta {
    String titular;
    int numero;
    String agencia;
    double saldo;
    //String abertura;
    //6º
    Data abertura;
    
    
    public boolean saca(double valor){
        if(this.saldo - valor >= 0){
            this.saldo -= valor;
            return true;
        }
        else{
            return false;
        } 
    }
    
    public void deposita(double valor){
        this.saldo += valor;
    }
    
    public double calculaRendimento(){
        return (this.saldo*0.1);
    }
    
    String recuperaDadosParaImpressao() {
             //String dados = "Titular: " + this.titular + "\nNúmero: " + this.numero + "\nAgência: " +this.agencia+"\nSaldo: " +this.agencia+"\nData de abertura: " +this.abertura;
             //7º
             //String dados = "Titular: " + this.titular + "\nNúmero: " + this.numero + "\nAgência: " +this.agencia+"\nSaldo: " +this.agencia+"\nData de abertura: Dia = " + this.abertura.dia + " Mês = " + this.abertura.mes + " Ano = " + this.abertura.ano;
             //9º
             String dados = "Titular: " + this.titular + "\nNúmero: " + this.numero + "\nAgência: " +this.agencia+"\nSaldo: " +this.agencia+"\nData de abertura: "+ abertura.dados();
             return dados;
    }

    
}
