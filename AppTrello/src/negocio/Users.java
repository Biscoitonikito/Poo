
package negocio;

import java.util.ArrayList;
import model.Usuario;


public class Users {
    private ArrayList <Usuario> listaUsuario;
    
    Users(){
        this.listaUsuario = new ArrayList<Usuario>();
    }
    
    public void criarUsuario(String nome,String login, int senha){
        Usuario usuario = new Usuario(nome,login,senha);
        this.listaUsuario.add(usuario);
    } 
}
