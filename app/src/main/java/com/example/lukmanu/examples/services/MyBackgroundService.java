package com.example.lukmanu.examples.services;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.example.lukmanu.examples.MainActivity;
import com.example.lukmanu.examples.R;

public class MyBackgroundService extends Service
{
    private static final int NOTIFICATION_SERVICE = 1;

    @Override
    public void onCreate()
    {
        super.onCreate();
        Toast.makeText(this, "Servicio creado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        //Si queremos que se muestre una notificacion mientras esté corriendo nuestro servicio
//        showForegroundNotification(getApplicationContext().getResources().getString(R.string.texto_servicio));

        Toast.makeText(this, "Servicio arrancado " + startId, Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy()
    {
        Toast.makeText(this, "Servicio detenido", Toast.LENGTH_SHORT).show();

        // The service is no longer used and is being destroyed
//        stopForeground(true);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    private void showForegroundNotification(String contentText)
    {
        // Create intent that will bring our app to the front, as if it was tapped in the app
        // launcher
        Intent showTaskIntent = new Intent(getApplicationContext(), MainActivity.class);
        showTaskIntent.setAction(Intent.ACTION_MAIN);
        showTaskIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        showTaskIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent contentIntent = PendingIntent.getActivity(
                getApplicationContext(),
                0,
                showTaskIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext())
                .setContentTitle(getString(R.string.app_name))
                .setContentText(contentText)
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(contentIntent);

        startForeground(NOTIFICATION_SERVICE, notification.build());
    }

}
