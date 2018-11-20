
package app;

import java.util.Scanner;
import negocio.Users;

public class AppTrello {

    public static void main(String[] args){
      Users users = new Users();
      
      while(true == true){
        int opcao1;
        System.out.println("Você deseja:\n 1 - Entrar em uma conta\n 2 - Criar uma conta");
        Scanner opcao = new Scanner(System.in);
        opcao1 = opcao.nextInt();
        
        if(opcao1 == 1){
            boolean logado = false;
            System.out.println("Ditite Seu Email:");
            String email;
            Scanner emailL = new Scanner(System.in);
            email = emailL.next();
            System.out.println("Ditite Sua Senha:");
            int Lsenha;
            Scanner senhaL = new Scanner(System.in);
            Lsenha = senhaL.nextInt();
            int usuario = 0;
            
            
            for(int i = 0; i < users.getListaUsuario().size(); i++){
                /*System.out.println("\n");
                System.out.println(users.getListaUsuario().size());
                System.out.println(users.getListaUsuario().get(i).getPerfil().getNome());
                System.out.println(users.getListaUsuario().get(i).getPerfil().getLogin());
                System.out.println(users.getListaUsuario().get(i).getPerfil().getSenha());
                
                if(users.getListaUsuario().get(i).getPerfil().getSenha() == Lsenha){
                    System.out.println(users.getListaUsuario().get(i).getPerfil().getNome());
                    System.out.println("oi1");
                }*/
                if(users.getListaUsuario().get(i).getPerfil().getLogin() == null ? email == null : users.getListaUsuario().get(i).getPerfil().getLogin().equals(email)){
                    if(users.getListaUsuario().get(i).getPerfil().getSenha() == Lsenha){
                    logado = true;
                    usuario = i;
                    }
                }
            }
            
            
            if(logado == false){
                System.out.println("Dados incorretos");
            }
            
            else{
                while(logado == true){
                    System.out.println("Quadros existentes:\n");
                    for(int i = 0; i< users.getListaUsuario().get(i).getListaQuadros().size(); i++){
                        if(users.getListaUsuario().get(usuario).getQuadro(i).isFechado() == false){
                            System.out.println((i+1) + " - " + users.getListaUsuario().get(usuario).getQuadro(i).getTitulo() + "\n");
                        }
                    }
                    System.out.println(users.getListaUsuario().get(usuario).getPerfil().getNome() + " o que deseja fazer?\n 1 - Criar quadros\n 2 - Fechar Quadro\n 3 - Remover Quadro\n 4 - Copiar Quadro\n 5 - Buscar Quadro\n 6 - Configuração");
                    
                    System.out.println("Deseja sair?\n 1 - sim\n 2 - nao");
                    int opcao2;
                    Scanner escolha = new Scanner(System.in);
                    opcao2 = escolha.nextInt();
            
                    if(opcao2 == 1){
                        logado = false;
                    }
            
                    else{
                        logado = true;
                    }
            
                }
            }
        }          
        
        if(opcao1 == 2){
            System.out.println("Ditite Seu Nome:");
            String nome;
            Scanner nameC = new Scanner(System.in);
            nome = nameC.next();
            System.out.println("Ditite Seu Email:");
            String Cemail;
            Scanner emailC = new Scanner(System.in);
            Cemail = emailC.next();
            System.out.println("Ditite Sua Senha:");
            int senha;
            Scanner senhaC = new Scanner(System.in);
            senha = senhaC.nextInt();
            users.criarUsuario(nome, Cemail, senha);
            
        }
      }
    }
}
