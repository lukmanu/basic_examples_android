package com.example.lukmanu.examples.notifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;

import com.example.lukmanu.examples.R;

public class NotificationsActivity extends Activity implements View.OnClickListener
{
    private int notificationId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);

        findViewById(R.id.notification_bttn_1).setOnClickListener(this);
        findViewById(R.id.notification_bttn_2).setOnClickListener(this);
        findViewById(R.id.notification_bttn_3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.notification_bttn_1:
                launchNotification1();
                break;
            case R.id.notification_bttn_2:
                launchNotification2();
                break;
            case R.id.notification_bttn_3:
                launchNotification3();
                break;
        }
    }

    private void launchNotification1()
    {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(android.R.drawable.ic_menu_compass) //Icono pequeño
                        .setContentTitle("Título de la Notificación")
                        .setContentText("Texto de la Notificación")
                        .setAutoCancel(true) //autocierre al pulsar
                        .setTicker("Notificación!"); //texto que aparecerá en la barra de navegación la 1ª vez

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(notificationId++, mBuilder.build());
    }

    /**
     * Notificaciones con icono y texto a la derecha
     */
    private void launchNotification2()
    {
        //Intent con la acción al pulsar la notificación - En este ejemplo volvemos a la misma Activity
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/lukmanu/basic_examples_android"));
        PendingIntent contIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

//Icono grande
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_menu_compass);

        //Builder con los parámetros de la notificación
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(android.R.drawable.ic_menu_compass) //Icono pequeño
                        .setLargeIcon(bitmap) //icono grande
                        .setContentTitle("Título de la Notificación")
                        .setContentText("Texto de la Notificación")
                        .setContentInfo("Texto a la derecha")
                        .setSubText("Subtexto de la notificación")
                        .setContentIntent(contIntent) // accion al pulsar
                        .setAutoCancel(true) //autocierre al pulsar
                        .setTicker("Notificación!"); //texto que aparecerá en la barra de navegación la 1ª vez


        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(notificationId++, mBuilder.build());
    }

    /**
     * Notificaciones tipo Lollipop
     */
    private void launchNotification3()
    {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_menu_compass);

        Intent intent = new Intent(this, NotificationsActivity.class);
        PendingIntent piDismiss = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.ic_menu_compass)
                .setLargeIcon(bitmap)
                .setContentTitle("Titulo")
                .setContentText("Texto del contenido")
                .setStyle(
                        new NotificationCompat.BigTextStyle().bigText("Texto del contenido expandido"))
                .addAction(android.R.drawable.ic_menu_add, "Acción 1", piDismiss)
                .addAction(android.R.drawable.ic_menu_revert, "Acción 2", piDismiss)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC) // Visibilidad de la notificación
                .setAutoCancel(true);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(notificationId++, mBuilder.build());
    }
}

