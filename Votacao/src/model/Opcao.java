
package model;


class Opcao {
    private String opcaoEscopo;
    private boolean marcado;
    private int contador;
    
    Opcao(String escopo){
        this.opcaoEscopo = escopo;
        this.marcado = false;
        this.contador = 0;
    }

    public String getOpcapEscopo() {
        return opcaoEscopo;
    }

    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado() {
        this.marcado = true;
    }

    public int getContador() {
        return contador;
    }

    public void aumentaContador() {
        this.contador += 1;
    }
    
    
}
