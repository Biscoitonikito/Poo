package com.example.guilherme.atividadex.activity;

import com.example.guilherme.atividadex.controller.UsuarioController;
import com.example.guilherme.atividadex.model.Convite;
import com.example.guilherme.atividadex.model.Logado;
import com.example.guilherme.atividadex.model.Medicamento;
import com.example.guilherme.atividadex.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//PARA TESTAR CADA METODO BASTA APENA TIRALO DE DENTRO DO COMENTARIO
public class MainActivity {
    public static void main(String[] args) {

        List<Usuario> usuarioList = new ArrayList<>();
        List<Medicamento> medicamentoList = new ArrayList<>();
        List<Logado> logadoList = new ArrayList<>();
        List<Convite> conviteList = new ArrayList<>();

        //Metodos para cadastrar genericos, funcionam mesmo sem bd, so passando os dados;
        //Só necessitam de uma lista para guarda o retorno que e o usuari craido

        String email = "guilherme";
        String senha = "123";
        String confirmSenha = "123";
        String nome = "Guilherme Sousa";
        String endereco = "asdas";
        String telefone = "aasd";


        if (UsuarioController.cadastrarUsuario(usuarioList, email, senha, confirmSenha, nome, endereco, telefone) != null) {
            usuarioList.add(Objects.requireNonNull(UsuarioController.cadastrarUsuario(usuarioList, email, senha, confirmSenha, nome,
                    endereco, telefone)));
        }

        //Como a responsabilidade de preencher o id é do Bd, aki tenho de colocar manualmente, ja que os metodos não recebem
        //esse dado pois seria redudante pra aplicação
        //usuarioList.get(0).setId(2);

        usuarioList.removeAll(usuarioList);

        Usuario a = new Usuario(email, senha, nome, endereco, telefone);
        a.setId(2);
        usuarioList.add(a);
    }
}

