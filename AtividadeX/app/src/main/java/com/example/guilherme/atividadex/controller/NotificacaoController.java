package com.example.guilherme.atividadex.controller;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.example.guilherme.atividadex.R;
import com.example.guilherme.atividadex.model.Medicamento;
import com.example.guilherme.atividadex.model.Notificacao;
import com.example.guilherme.atividadex.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.content.Context.NOTIFICATION_SERVICE;

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



    public static Notificacao gerarNovoVinculo(long idUsuarioOne, long idUsuarioTwo, String nome){
        String corpo = "O usuário(a) " + nome + " de codigo" + idUsuarioOne + " quer saber se quer se vincular a ele?";
        return new Notificacao(idUsuarioOne,idUsuarioTwo,corpo);
    }



    public static List<Usuario> answerVinculo(Context context, List<Notificacao> notificacaoList, long id, List<Usuario> usuarioList) {
        Notificacao notificacao = NotificacaoController.verificarPedidoVinculo(notificacaoList, id);
        if(notificacao !=null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);

            builder.setTitle("Pedido de Vínculo:");
            builder.setMessage(Objects.requireNonNull(notificacao).getConteudo());
            builder.setPositiveButton("Sim", (dialogInterface, i) -> {
                confirmaVinculo(usuarioList, notificacao.getIdUsuarioOne(),notificacao.getIdUsuarioTwo());
            });
            builder.setNegativeButton("NÃO", (dialogInterface, i)->{
                notificacao.setAnswer(false);
            });
            builder.create().show();
        }
        return usuarioList;
    }

    private static Notificacao verificarPedidoVinculo(List<Notificacao> notificacaoList, long id){
        for(int i = 0; i< notificacaoList.size(); i++){
            if(notificacaoList.get(i).getIdUsuarioTwo()== id){
                return notificacaoList.get(i);
            }
        }
        return null;
    }

    private static List<Usuario> confirmaVinculo(List<Usuario> usuarioList, long idOne, long idTwo){
        for(int i = 0; i < usuarioList.size(); i++){
            if(usuarioList.get(i).getId() == idOne){
                usuarioList.get(i).setIdUsuarioVinculado(idTwo);
            }
            if(usuarioList.get(i).getId() == idTwo){
                usuarioList.get(i).setIdUsuarioVinculado(idOne);
            }
        }
        return usuarioList;
    }


}
