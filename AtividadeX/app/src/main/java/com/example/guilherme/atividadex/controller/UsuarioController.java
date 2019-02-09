package com.example.guilherme.atividadex.controller;

import android.content.Context;
import android.widget.Toast;

import com.example.guilherme.atividadex.model.Logado;
import com.example.guilherme.atividadex.model.Usuario;

import java.util.List;

public class UsuarioController {

    //METODOS ESPECIFICOS DO CADASTRO
    public static Usuario cadastrarUsuario(Context context,List<Usuario> usuarioList, String email, String senha, String confirmSenha, String nome, String endereco, String telefone){

        switch (UsuarioController.validarDados(usuarioList,email,senha,nome,confirmSenha,endereco,telefone)){
            case 0:
                return new Usuario(email,senha,nome,endereco,telefone);
            case 1:
                Toast.makeText(context, "USUÁRIO JA EXISTENTE", Toast.LENGTH_LONG).show();
                break;
            case 2:
                Toast.makeText(context, "PREENCHA OS CAMPOS", Toast.LENGTH_LONG).show();
                break;
            case 3:
                Toast.makeText(context, "SENHAS NÃO BATEM", Toast.LENGTH_LONG).show();
                break;

        }
        return null;
    }

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
                                return 3;
                            }
                            return 2;
                        }
                        return 2;
                    }
                    return 2;
                }
                return 2;
            }
            return 2;
        }
        return 2;
    }

    //MÉTODOS PARA LOGIN
    public static Logado loginUsuario(Context context, List<Usuario> usuarioList, String email, String senha) {
        long id = UsuarioController.buscarUsuario(usuarioList,email,senha);

        if(id != 0) {
            Logado logado = new Logado();
            logado.setIdLogado(id);
            return logado;
        }
        else{
            Toast.makeText(context, "DADOS INCORRETOS OU \n USUARIO NÃO EXISTE", Toast.LENGTH_LONG).show();
            return null;
        }
    }

    private static long buscarUsuario(List<Usuario> usuarioList, String email, String senha){

        for(int i = 0; i < usuarioList.size(); i++){
            if(usuarioList.get(i).getEmail().equals(email) && usuarioList.get(i).getSenha().equals(senha)){
                return usuarioList.get(i).getId();
            }
        }

        return 0;
    }
}
