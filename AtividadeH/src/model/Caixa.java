
package model;

public class Caixa {
    
    public void sacar(Conta conta, double valor){
        conta.sacar(valor);
    }
    
    public void sacar(ContaCapital conta,double valor, String data){
        if(conta.getData() == data){
            conta.sacar(valor);
        }
    }
    
    public String sacar(ContaDigital conta, double valor){
        return "Não é possível efetuar essa ação";
    }
    
    public void deposita(Conta conta, double valor){
        conta.depositar(valor);
    }
    
    public String status(Conta conta){
        return conta.status();
    }
}
