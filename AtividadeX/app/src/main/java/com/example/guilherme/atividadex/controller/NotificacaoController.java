package com.example.guilherme.atividadex.controller;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.example.guilherme.atividadex.R;
import com.example.guilherme.atividadex.model.Medicamento;

import java.util.List;

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
}
