
package modelCap5;

public class Conta {
    private String titular;
    private int identificador;
    private String agencia;
    private double saldo;
    private Data abertura;
    private static int contador = 1;
   
    public Conta() {
        this.identificador = contador;
        contador ++;
    }

    public Conta(String titular) {
        this.titular = titular;
        this.identificador = contador;
        contador ++;
    }
   

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getAgencia() {
        return agencia;
    }


    public double getSaldo() {
        return saldo;
    }

    public Data getAbertura() {
        return abertura;
    }
    
    
    public boolean saca(double valor){
        if(this.saldo < valor){
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
    
    public double getRendimento(){
        return (this.saldo*0.1);
    }
    
    String recuperaDadosParaImpressao() {
             String dados = "Titular: " + this.titular + "\nNúmero: " + this.identificador + "\nAgência: " +this.agencia+"\nSaldo: " +this.agencia+"\nData de abertura: "+ abertura.dados();
             return dados;
    }

    
}
