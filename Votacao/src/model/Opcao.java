
package model;


public class Opcao {
    private String escopo;
    private int contador;
    
    public Opcao(String escopo){
        this.escopo = escopo;
        this.contador = 0;
    }
    
    public Opcao(){
        this.contador = 0;
        this.escopo = "Opcão Invalida";
    }

    public String getOpcapEscopo() {
        return escopo;
    }

    public int getContador() {
        return contador;
    }

    public void aumentaContador() {
        this.contador += 1;
    }
    
    
}
