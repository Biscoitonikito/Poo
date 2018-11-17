
package model;


public class Opcao {
    private String escopo;
    private boolean marcado;
    private int contador;
    
    public Opcao(String escopo){
        this.escopo = escopo;
        this.marcado = false;
        this.contador = 0;
    }

    public String getOpcapEscopo() {
        return escopo;
    }

    public int getContador() {
        return contador;
    }
    
    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado() {
        if(this.marcado == false){
            this.marcado = true;
            aumentaContador();
        }
        else{
            this.marcado = false;
            diminuirContador();
        }
    }
    
    private void aumentaContador() {
        this.contador += 1;
    }
    
    private void diminuirContador() {
        this.contador -= 1;
    }
    
    
    
    
}
