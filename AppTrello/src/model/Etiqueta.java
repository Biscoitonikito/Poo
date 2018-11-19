
package model;


class Etiqueta {
    String cor;
    String conteudo;
    
    Etiqueta(String cor, String conteudo){
        if(conteudo == ""){
           this.cor = cor;
           this.conteudo = "";
        }
        else{
           this.cor = cor;
           this.conteudo = conteudo;
        }
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
    
}
