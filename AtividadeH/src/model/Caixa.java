
package model;

public class Caixa {
    
    public String sacar(Conta conta, double valor){
        double r = conta.sacar(valor);
        
        if(r != 0){
            return "Operação concluída";
        }
        
        return null;
    }
    
    public String sacar(ContaCapital conta, double valor, String data){
        if(conta.getData() == data){
            double r = conta.sacar(valor);
        
            if(r != 0){
                return "Operação concluída";
            }
        
            return null;
        }
        return null;
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
