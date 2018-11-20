
package negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Usuario;


public class Users {
    private ArrayList <Usuario> listaUsuario;
    
    public Users(){
        this.listaUsuario = new ArrayList<Usuario>();
    }
    
    public void criarUsuario(String nome,String login, int senha){
        Usuario usuario = new Usuario(nome,login,senha);
        this.listaUsuario.add(usuario);
    }

    public List<Usuario> getListaUsuario() {
        return Collections.unmodifiableList(listaUsuario);
    }
}
