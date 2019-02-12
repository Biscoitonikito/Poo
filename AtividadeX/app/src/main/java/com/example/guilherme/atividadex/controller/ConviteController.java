package com.example.guilherme.atividadex.controller;

import android.app.AlertDialog;
import android.content.Context;

import com.example.guilherme.atividadex.model.Convite;
import com.example.guilherme.atividadex.model.Usuario;

import java.util.List;
import java.util.Objects;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class ConviteController {
    //Gera um pedido de vinculo
    public static Convite gerarNovoVinculo(List<Usuario> list, long idUsuarioOne, String idUsuarioTwo, String nome){
        String idLongOne = String.valueOf(idUsuarioOne);
        if(!idUsuarioTwo.isEmpty()) {
            if(!idLongOne.equals(idUsuarioTwo)) {
                long idLongTwo = Long.parseLong(idUsuarioTwo);
                if (UsuarioController.buscarUsuarioId(list, idLongTwo) != null) {
                    String corpo = "O usuário(a) " + nome + " de codigo " + idUsuarioOne + " quer saber se quer se vincular a ele?";
                    return new Convite(idUsuarioOne, idLongTwo, corpo);
                }
                return null;
            }
            return null;
        }
        return null;
    }



    //Esse metodo não  conseguir uma forma de escapar de passar a BoxStore
    //Neste metodo ele infla uma pergunta em caso de afirmativo vincula os 2 usuarios
    public static void answerVinculo(Context context, BoxStore boxStore, long id) {
        Box<Usuario> usuarioBox = boxStore.boxFor(Usuario.class);
        Box<Convite> notificacaoBox = boxStore.boxFor(Convite.class);
        List<Usuario> usuarioList = usuarioBox.getAll();
        List<Convite> conviteList = notificacaoBox.getAll();

        Convite convite = ConviteController.verificarPedidoVinculo(conviteList, id);
        if(convite !=null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Pedido de Vínculo:");
            builder.setMessage(Objects.requireNonNull(convite).getConteudo());
            builder.setPositiveButton("Sim", (dialogInterface, i) -> {
                notificacaoBox.remove(convite);
                usuarioBox.removeAll();
                usuarioBox.put(UsuarioController.vincular(usuarioList, convite));

            });
            builder.setNegativeButton("NÃO", (dialogInterface, i)-> notificacaoBox.remove(convite));
            builder.create().show();
        }
    }

    //Busca o pedido de vinculo relacionado a cada usuario
    private static Convite verificarPedidoVinculo(List<Convite> conviteList, long id){
        for(int i = 0; i< conviteList.size(); i++){
            if(conviteList.get(i).getIdUsuarioTwo()== id){
                return conviteList.get(i);
            }
        }
        return null;
    }
}
