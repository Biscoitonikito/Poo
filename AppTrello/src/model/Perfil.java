
package model;

class Perfil {
    String nome;
    String login;
    int senha;
    
    Perfil(String nome,String login, int senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    
    public boolean validar(String login, int senha){
        if(this.login == login && this.senha == senha){
            return true;
        }
        return false;
    }

    public String getLogin() {
        return this.login;
    }
    
    public String getNome(){
        return this.nome;
    }
     
}
