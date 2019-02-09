package com.example.guilherme.atividadex.bd;

import com.example.guilherme.atividadex.dal.App;
import com.example.guilherme.atividadex.model.Medicamento;
import com.example.guilherme.atividadex.model.Usuario;

import java.util.List;

import io.objectbox.Box;

public class ObjectBox {


    //Trabalha com a classe Usuario
    public static List<Usuario> obterBoxUsuario(App app){
        Box<Usuario> box = app.getBoxStore().boxFor(Usuario .class);
        return box.getAll();
    }

    public static void adicionarUsuario(Usuario usuario, App app){
        Box<Usuario>box = app.getBoxStore().boxFor(Usuario .class);
        box.put(usuario);
    }

    public static void modificarUsuario(Usuario usuario, App app){
        Box<Usuario> box = app.getBoxStore().boxFor(Usuario .class);
        box.put(usuario);
    }


    //Trabalha com a classe Medicamento
    public static List<Medicamento> obterBoxMedicamento(App app){
        Box<Medicamento> box = app.getBoxStore().boxFor(Medicamento .class);
        return box.getAll();
    }

    public static void adicionarMedicamento(Medicamento medicamento, App app){
        Box<Medicamento>box = app.getBoxStore().boxFor(Medicamento .class);
        box.put(medicamento);
    }

    public static void modificarMedicamento(Medicamento medicamento, App app){
        Box<Medicamento> box = app.getBoxStore().boxFor(Medicamento.class);
        box.put(medicamento);
    }

    //Usario Logado
    public static Usuario usuarioLogado(String email, String senha, App app){
        Box<Usuario> box = app.getBoxStore().boxFor(Usuario .class);
        Usuario a = new Usuario();
        return a;
    }



}
