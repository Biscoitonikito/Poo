
package negocio;

import java.io.File;


public class Intermediaria {
    File diretorio = new File("C:\\Users\\Guilherme\\Documents");
    
    public void cria(){
        this.diretorio.mkdir();
    }

}
