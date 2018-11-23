
package app;

import java.util.Scanner;
import model.Users;

public class AppTrello {

    public static void main(String[] args){
      Users users = new Users();
      
      while(true == true){
        int opcao1;
        System.out.println("\n\n\n\nVocê deseja:\n 1 - Entrar em uma conta\n 2 - Criar uma conta");
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
            
            
            for(int i = 0; i < users.getSize(); i++){
                if(users.getUsuario(i).getPerfil().getLogin() == null ? email == null : users.getUsuario(i).getPerfil().getLogin().equals(email)){
                    if(users.getUsuario(i).getPerfil().getSenha() == Lsenha){
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
                    System.out.println("/nQuadros existentes:\n");
                    for(int i = 0; i< users.getUsuario(usuario).getSize(); i++){
                        if(!users.getUsuario(usuario).getQuadro(i).isFechado()){
                            System.out.println((i+1) + " - " + users.getUsuario(usuario).getQuadro(i).getTitulo() + "\n");
                        }
                    }
                    
                    System.out.println(users.getUsuario(usuario).getPerfil().getNome() + " o que deseja fazer?\n 1 - Criar quadros\n 2 - Acessar Quadro\n 3 - Fechar Quadro\n 4 - Remover Quadro\n 5 - Copiar Quadro\n 6 - Buscar Quadro\n 7 - Configuração\n 0 - Sair/n");
                    int opcao2;
                    Scanner op2 = new Scanner(System.in);
                    opcao2 = op2.nextInt();
                    
                    if(opcao2 == 1){
                        System.out.println("Digite o nome");
                        String nomeQuadro;
                        Scanner nameQ = new Scanner(System.in);
                        nomeQuadro = nameQ.next();
                        users.getUsuario(usuario).criarQuadro(nomeQuadro);
                    }
                    
                    if(opcao2 == 2){
                        System.out.println("Quadros existentes:\n");
                            for(int i = 0; i< users.getUsuario(usuario).getSize(); i++){
                                if(!users.getUsuario(usuario).getQuadro(i).isFechado()){
                                    System.out.println((i+1) + " - " + users.getUsuario(usuario).getQuadro(i).getTitulo() + "\n");
                                }
                            }
                        System.out.println("Qual quadro quer acessar?\n");
                        int posicaoQuadro;
                        Scanner nameQ = new Scanner(System.in);
                        posicaoQuadro = nameQ.nextInt();
                        posicaoQuadro -= 1;
                        boolean acessarQuadro = false;
                        
                        if(!users.getUsuario(usuario).getQuadro(posicaoQuadro).isFechado()){
                            if(posicaoQuadro > 0 && posicaoQuadro <= users.getUsuario(usuario).getSize()){
                                acessarQuadro = true;
                                System.out.println("\n\n\nListas existentes neste quadro:");
                                for(int i = 0; i < users.getUsuario(usuario).getQuadro(posicaoQuadro).getSize(); i++){
                                    if(!users.getUsuario(usuario).getQuadro(posicaoQuadro).getLista(i).isArquivada()){
                                        System.out.println((i+1) + " - " + users.getUsuario(usuario).getQuadro(posicaoQuadro).getLista(i).getTitulo());
                                        for(int j = 0; i < users.getUsuario(usuario).getQuadro(posicaoQuadro).getLista(i).getSize();i++){
                                            if(!users.getUsuario(usuario).getQuadro(posicaoQuadro).getLista(i).getCartao(j).isArquivada()){
                                                System.out.println(users.getUsuario(usuario).getQuadro(posicaoQuadro).getLista(i).getCartao(i).status()+"\n");
                                            }
                                        }
                                    }
                                }
                            }
                            
                            while(acessarQuadro = true){
                        
                                System.out.println("O que deseja fazer neste quadro;\n 1 - Mudar Nome\n 2 - Mudar Nome da Lista\n 3 - Copiar Lista\n 4 - Arquiva Lista\n 5 - Deletar Lista\n 6 - Tornar-lo Favorito"
                                    + "\n 7 - Mudar Visibildade");
                        
                                int opcao3;
                                Scanner op3 = new Scanner(System.in);
                                opcao3 = op3.nextInt();
                            
                                if(opcao3 == 1){
                                    System.out.println("Digite o novo nome e em caso de querer cancelar apenas não digite nada.");
                                    String newNome;
                                    Scanner nome = new Scanner(System.in);
                                    newNome = nome.next();
                                
                                    if(newNome == ""){
                                        System.out.println("Nome não alterado.");
                                    }
                                    else{
                                        users.getUsuario(usuario).getQuadro(posicaoQuadro).setTitulo(newNome);
                                    }
                                }
                        
                                if(opcao3 == 2){
                                    for(int i = 0; i < users.getUsuario(usuario).getQuadro(posicaoQuadro).getSize(); i++){
                                        if(!users.getUsuario(usuario).getQuadro(posicaoQuadro).getLista(i).isArquivada()){
                                            System.out.println((i+1) + " - " + users.getUsuario(usuario).getQuadro(posicaoQuadro).getLista(i).getTitulo());
                                        }
                                    }
                                
                                    int numLista;
                                    Scanner lista = new Scanner(System.in);
                                    numLista = lista.nextInt();
                                    numLista -= 1;
                            
                                    if(numLista > 0 && numLista < users.getUsuario(usuario).getQuadro(posicaoQuadro).getSize()){
                                        if(!users.getUsuario(usuario).getQuadro(posicaoQuadro).getLista(numLista).isArquivada()){
                                            System.out.println("Digite o novo nome e em caso de querer cancelar apenas não digite nada.");
                                            String newNome;
                                            Scanner nome = new Scanner(System.in);
                                            newNome = nome.next();
                                            if(newNome == ""){
                                                System.out.println("Nome não alterado.");
                                            }
                                            else{
                                                users.getUsuario(usuario).getQuadro(posicaoQuadro).getLista(numLista).setTitulo(newNome);
                                            }
                                        }
                                    }
                                }
                        
                                if(opcao3 == 3){
                                    for(int i = 0; i < users.getUsuario(usuario).getQuadro(posicaoQuadro).getSize(); i++){
                                        if(!users.getUsuario(usuario).getQuadro(posicaoQuadro).getLista(i).isArquivada()){
                                            System.out.println((i+1) + " - " + users.getUsuario(usuario).getQuadro(posicaoQuadro).getLista(i).getTitulo());
                                        }
                                    }
                            
                                    int numLista;
                                    Scanner lista = new Scanner(System.in);
                                    numLista = lista.nextInt();
                                    numLista -= 1;
                            
                                    if(numLista > 0 && numLista < users.getUsuario(usuario).getQuadro(posicaoQuadro).getSize()){
                                        if(!users.getUsuario(usuario).getQuadro(posicaoQuadro).getLista(numLista).isArquivada()){
                                            users.getUsuario(usuario).getQuadro(posicaoQuadro).copiarLista(numLista);
                                        }
                                    }
                                }
                            
                                if(opcao3 == 4){
                                    for(int i = 0; i < users.getUsuario(usuario).getQuadro(posicaoQuadro).getSize(); i++){
                                        if(!users.getUsuario(usuario).getQuadro(posicaoQuadro).getLista(i).isArquivada()){
                                            System.out.println((i+1) + " - " + users.getUsuario(usuario).getQuadro(posicaoQuadro).getLista(i).getTitulo());
                                        }
                                    }
                                
                                    int numLista;
                                    Scanner lista = new Scanner(System.in);
                                    numLista = lista.nextInt();
                                    numLista -= 1;
                            
                                    if(numLista > 0 && numLista < users.getUsuario(usuario).getQuadro(posicaoQuadro).getSize()){
                                        if(!users.getUsuario(usuario).getQuadro(posicaoQuadro).getLista(numLista).isArquivada()){
                                            users.getUsuario(usuario).getQuadro(posicaoQuadro).arquivaLista(numLista);
                                        }
                                    }
                                }
                            
                                if(opcao3 == 5){
                                    for(int i = 0; i < users.getUsuario(usuario).getQuadro(posicaoQuadro).getSize(); i++){
                                        if(users.getUsuario(usuario).getQuadro(posicaoQuadro).getLista(i).isArquivada()){
                                            System.out.println((i+1) + " - " + users.getUsuario(usuario).getQuadro(posicaoQuadro).getLista(i).getTitulo());
                                        }
                                    }
                                
                                    int numLista;
                                    Scanner lista = new Scanner(System.in);
                                    numLista = lista.nextInt();
                                    numLista -= 1;
                            
                                    if(numLista > 0 && numLista < users.getUsuario(usuario).getQuadro(posicaoQuadro).getSize()){
                                        if(users.getUsuario(usuario).getQuadro(posicaoQuadro).getLista(numLista).isArquivada()){
                                            users.getUsuario(usuario).getQuadro(posicaoQuadro).arquivaLista(numLista);
                                        }
                                    }
                                }
                        
                                if(opcao3 == 6){
                                    
                                }
                            
                                if(opcao3 == 7){
                                    
                                }
                            
                                if(opcao3 == 0){
                                    acessarQuadro = false;
                                }
                            }
                        }
                        
                    }
                    
                    if(opcao2 == 3){
                        for(int i = 0; i< users.getUsuario(usuario).getSize(); i++){
                            if(!users.getUsuario(usuario).getQuadro(i).isFechado()){
                                System.out.println((i+1) + " - " + users.getUsuario(usuario).getQuadro(i).getTitulo() + "\n");
                            }
                        }
                        int fecharQuadro;
                        System.out.println("Digite o número do Quadro do qual quer fechar: ");
                        Scanner fecharQ = new Scanner(System.in);
                        fecharQuadro = fecharQ.nextInt();
                        fecharQuadro -= 1;
                        if(!users.getUsuario(usuario).getQuadro(fecharQuadro).isFechado()){
                            users.getUsuario(usuario).fecharQuadro(fecharQuadro);
                        }
                    }
                    
                    if(opcao2 == 4){
                        for(int i = 0; i< users.getUsuario(usuario).getSize(); i++){
                            if(users.getUsuario(usuario).getQuadro(i).isFechado()){
                                System.out.println((i+1) + " - " + users.getUsuario(usuario).getQuadro(i).getTitulo() + "\n");
                            }
                        }
                        int excluirQuadro;
                        System.out.println("Digite o número do Quadro que quer irá ser removido: ");
                        Scanner excluirQ = new Scanner(System.in);
                        excluirQuadro = excluirQ.nextInt();
                        excluirQuadro -= 1;
                        if(users.getUsuario(usuario).getQuadro(excluirQuadro).isFechado()){
                            users.getUsuario(usuario).removerQuadro(excluirQuadro);
                        }
                    }
                    
                    if(opcao2 == 5){
                        for(int i = 0; i< users.getUsuario(usuario).getSize(); i++){
                            if(!users.getUsuario(usuario).getQuadro(i).isFechado()){
                                System.out.println((i+1) + " - " + users.getUsuario(usuario).getQuadro(i).getTitulo() + "\n");
                            }
                        }
                        int copiarQuadro;
                        System.out.println("Digite o número do Quadro do qual quer copiar: ");
                        Scanner copiarQ = new Scanner(System.in);
                        copiarQuadro = copiarQ.nextInt();
                        copiarQuadro -= 1;
                        if(!users.getUsuario(usuario).getQuadro(copiarQuadro).isFechado()){
                            users.getUsuario(usuario).copiarQuadro(copiarQuadro);
                        }
                    }
                    
                    if(opcao2 == 6){
                        String buscaQuadro;
                        System.out.println("Digite o nome do Quadro do qual quer procurar: ");
                        Scanner buscaQ = new Scanner(System.in);
                        buscaQuadro = buscaQ.next();
                        if(users.getUsuario(usuario).buscaQuadro(buscaQuadro).isFechado()){
                            System.out.println(users.getUsuario(usuario).buscaQuadro(buscaQuadro).getTitulo());
                        }
                    }
                    
                    if(opcao2 == 7){
                        
                    }
                    
                    if(opcao2 == 0){
                        logado = false;
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
