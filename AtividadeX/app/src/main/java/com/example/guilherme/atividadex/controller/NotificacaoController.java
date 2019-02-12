package com.example.guilherme.atividadex.controller;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.example.guilherme.atividadex.R;
import com.example.guilherme.atividadex.model.Medicamento;
import com.example.guilherme.atividadex.model.Notificacao;
import com.example.guilherme.atividadex.model.Usuario;

import java.util.List;
import java.util.Objects;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class NotificacaoController {

    //Recebe a lista de medicaementos e apos chamar o metodo medicamentoALembrar gera uma notificacao em caso
    //de retorno true
    public static void notificar(List<Medicamento> medicamentoList, Context context, String corpo, NotificationManager mNotifyMgr, NotificationManager notificationManager){
        if(MedicamentoController.medicamentoALembrar(medicamentoList, context)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Tste";
                String description = "Teste";
                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel channel = new NotificationChannel("Principal", name, importance);
                channel.setDescription(description);
                NotificationManager notificacaoManager = notificationManager;
                notificacaoManager.createNotificationChannel(channel);

                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(context, channel.getId())
                                .setSmallIcon(R.drawable.ic_launcher_foreground)
                                .setContentTitle("Não Va Se Esquecer")
                                .setContentText("Está na hora de olhar seus medicamentos");

                int mNotificationId = 001;

                NotificationManager mNotifyMgra = mNotifyMgr;

                mNotifyMgra.notify(mNotificationId, mBuilder.build());
            }
        }
    }

    //Gera um pedido de vinculo
    public static Notificacao gerarNovoVinculo(List<Usuario> list, long idUsuarioOne, String idUsuarioTwo, String nome){
        String idLongOne = String.valueOf(idUsuarioOne);
        if(!idUsuarioTwo.isEmpty()) {
            if(!idLongOne.equals(idUsuarioTwo)) {
                long idLongTwo = Long.parseLong(idUsuarioTwo);
                if (UsuarioController.buscarUsuarioId(list, idLongTwo) != null) {
                    String corpo = "O usuário(a) " + nome + " de codigo " + idUsuarioOne + " quer saber se quer se vincular a ele?";
                    return new Notificacao(idUsuarioOne, idLongTwo, corpo);
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
        Box<Notificacao> notificacaoBox = boxStore.boxFor(Notificacao.class);
        List<Usuario> usuarioList = usuarioBox.getAll();
        List<Notificacao> notificacaoList = notificacaoBox.getAll();

        Notificacao notificacao = NotificacaoController.verificarPedidoVinculo(notificacaoList, id);
        if(notificacao !=null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Pedido de Vínculo:");
            builder.setMessage(Objects.requireNonNull(notificacao).getConteudo());
            builder.setPositiveButton("Sim", (dialogInterface, i) -> {
                notificacaoBox.remove(notificacao);
                usuarioBox.removeAll();
                usuarioBox.put(UsuarioController.vincular(usuarioList,notificacao));

            });
            builder.setNegativeButton("NÃO", (dialogInterface, i)-> notificacaoBox.remove(notificacao));
            builder.create().show();
        }
    }

    //Busca o pedido de vinculo relacionado a cada usuario
    private static Notificacao verificarPedidoVinculo(List<Notificacao> notificacaoList, long id){
        for(int i = 0; i< notificacaoList.size(); i++){
            if(notificacaoList.get(i).getIdUsuarioTwo()== id){
                return notificacaoList.get(i);
            }
        }
        return null;
    }


}
