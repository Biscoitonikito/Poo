
package model;


public class Opcao {
    private String escopo;
    private boolean marcado;
    
    public Opcao(String escopo){
        this.escopo = escopo;
        this.marcado = false;
    }

    public String getOpcapEscopo() {
        return escopo;
    }
    
    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado() {
        if(this.marcado == false){
            this.marcado = true;
        }
        else{
            this.marcado = false;
        }
    }   
    
}
