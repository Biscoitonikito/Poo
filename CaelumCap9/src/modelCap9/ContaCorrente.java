
package modelCap9;

public class ContaCorrente extends Conta{
    
    @Override
    public String getTipo() {
        return "Conta Corrente";
           
    }
    
    @Override
     public boolean saca(double valor) {
         this.saldo -= (valor + 0.10);
         return true;
     }

}
