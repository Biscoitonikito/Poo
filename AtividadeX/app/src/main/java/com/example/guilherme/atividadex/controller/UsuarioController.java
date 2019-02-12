package com.example.guilherme.atividadex.controller;

import com.example.guilherme.atividadex.model.Convite;
import com.example.guilherme.atividadex.model.Logado;
import com.example.guilherme.atividadex.model.Usuario;

import java.util.List;

public class UsuarioController {

    //METODOS ESPECIFICOS DO CADASTRO
    //Recebe uma lista de usuarios, e passa os dados para o metodo validar dados que retorna
    //null ou um usuario novo
    public static Usuario cadastrarUsuario(List<Usuario> usuarioList, String email, String senha,
                                           String confirmSenha, String nome, String endereco, String telefone){

        switch (UsuarioController.validarDados(usuarioList,email,senha,nome,confirmSenha,endereco,telefone)){
            case 0:
                return new Usuario(email,senha,nome,endereco,telefone);
            case 1:
                return null;
        }
        return null;
    }

    //Verifica se existe algum usuario com mesma infomação ou campos vazios
    private static int validarDados(List<Usuario> usuarioList, String email, String senha, String nome,
                                       String confirmSenha, String endereco, String telefone){

        for(int i = 0; i < usuarioList.size(); i++){
            if(usuarioList.get(i).getEmail().equals(email)){
                return 1;
            }
        }

        if(!email.isEmpty()){
            if (!nome.isEmpty()){
                if (!senha.isEmpty()){
                    if(!confirmSenha.isEmpty()){
                        if(!endereco.isEmpty()){
                            if(!telefone.isEmpty()){
                                if(senha.equals(confirmSenha)){
                                    return 0;
                                }
                                return 1;
                            }
                            return 1;
                        }
                        return 1;
                    }
                    return 1;
                }
                return 1;
            }
            return 1;
        }
        return 1;
    }

    //MÉTODOS PARA LOGIN

    //Chama o metodo buscarUsuario que retorna um Id em caso de ser igual a 0 retorna usuario nulo em caso do usuario que esta tentando ser acessado não
    //existir ou dados tiverem errado se não retorna o Id do usuario que foi achado
    public static Logado loginUsuario(List<Usuario> usuarioList, String email, String senha) {
        long id = UsuarioController.buscarUsuarioLogin(usuarioList,email,senha);

        if(id != 0) {
            Logado logado = new Logado();
            logado.setIdLogado(id);
            return logado;
        }
        else{
            return null;
        }
    }

    //Verifica se existe algum usuario com o email ou senha passado e retorna o seu Id e em caso de
    //não achar ele retorna zero
    private static long buscarUsuarioLogin(List<Usuario> usuarioList, String email, String senha){

        for(int i = 0; i < usuarioList.size(); i++){
            if(usuarioList.get(i).getEmail().equals(email)){
                if(usuarioList.get(i).getSenha().equals(senha)){
                    return usuarioList.get(i).getId();
                }
            }
        }
        return 0;
    }

    //Busca usuario pelo Id do Usuario logado e o retorna;
    public static Usuario buscarUsuarioId(List<Usuario> usuarioList, List<Logado> logadoList){
        for(int i = 0; i < usuarioList.size(); i++){
            if(usuarioList.get(i).getId() == logadoList.get(0).getIdLogado()) {
                return usuarioList.get(i);
            }
        }
        return null;
    }

    //Procura um ususario pelo id digitado
    public static Usuario buscarUsuarioId(List<Usuario> usuarioList, long id){
        for(int i = 0; i < usuarioList.size(); i++){
            if(usuarioList.get(i).getId() == id) {
                return usuarioList.get(i);
            }
        }
        return null;
    }

    //Vincula 2 usuarios setando o atributo deles de vinculado com o Id de cada
    public  static List<Usuario> vincular(List<Usuario> usuarioList, Convite convite){
        for (int i = 0; i < usuarioList.size(); i++) {
            if (usuarioList.get(i).getId() == convite.getIdUsuarioOne()) {
                    usuarioList.get(i).setIdUsuarioVinculado(convite.getIdUsuarioTwo());
            }
            if (usuarioList.get(i).getId() == convite.getIdUsuarioTwo()) {
                    usuarioList.get(i).setIdUsuarioVinculado(convite.getIdUsuarioOne());
            }
        }
        return usuarioList;
    }
}
