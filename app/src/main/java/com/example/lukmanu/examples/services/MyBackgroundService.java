package com.example.lukmanu.examples.services;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import com.example.lukmanu.examples.MainActivity;
import com.example.lukmanu.examples.R;

public class MyBackgroundService extends Service
{
    private static final int NOTIFICATION_SERVICE = 1;

    int mStartMode;       // indicates how to behave if the service is killed
    IBinder mBinder;      // interface for clients that bind
    boolean mAllowRebind; // indicates whether onRebind should be used

    @Override
    public void onCreate()
    {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        showForegroundNotification(getApplicationContext().getResources().getString(R.string.texto_servicio));

        // The service is starting, due to a call to startService()
        return mStartMode;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        // A client is binding to the service with bindService()
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent)
    {
        // All clients have unbound with unbindService()
        return mAllowRebind;
    }

    @Override
    public void onRebind(Intent intent)
    {
        // A client is binding to the service with bindService(),
        // after onUnbind() has already been called
    }

    @Override
    public void onDestroy()
    {
        // The service is no longer used and is being destroyed
//        stopForeground(true);
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
