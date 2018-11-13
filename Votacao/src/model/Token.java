
package model;

public class Token {
    private int numero;
    private boolean utilizado;
    
    public Token(int numero){
        this.numero = numero;
        this.utilizado = false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isUtilizado() {
        return utilizado;
    }
    
    public void utilizar(){
        this.utilizado = true;
    }
}
