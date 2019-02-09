package com.example.guilherme.atividadex.controller;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.example.guilherme.atividadex.R;
import com.example.guilherme.atividadex.model.Medicamento;

import java.util.List;

import static android.content.Context.NOTIFICATION_SERVICE;

public class NotificacaoController {

    public static void notificar(List<Medicamento> medicamentoList, Context context, String corpo, NotificationManager mNotifyMgr, NotificationManager notificationManager){
        if()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Tste";
            String description = "Teste";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Principal", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificacaoManager = notificationManager;
            notificacaoManager.createNotificationChannel(channel);

            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(context,channel.getId())
                            .setSmallIcon(R.drawable.ic_launcher_foreground)
                            .setContentTitle("Não Va Se Esquecer")
                            .setContentText("Está na hora de olhar seus medicamentos");

            int mNotificationId = 001;

            NotificationManager mNotifyMgra = mNotifyMgr;

            mNotifyMgra.notify(mNotificationId, mBuilder.build());
        }
    }

    private medicamento



}
