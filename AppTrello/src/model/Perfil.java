
package model;

public class Perfil {
    private String nome;
    private String login;
    private int senha;
    
    Perfil(String nome,String login, int senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    
    public boolean validar(String login, int senha){
        if((this.login == null ? login == null : this.login.equals(login)) && this.senha == senha){
            return true;
        }
        return false;
    }

    public int getSenha() {
        return senha;
    }

    public String getLogin() {
        return this.login;
    }
    
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
    
    
     
}
