package com.example.lukmanu.examples.broadcast;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadcastReceiver extends android.content.BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        int level = intent.getIntExtra("level", 0);
        Log.d("", "Batería: " + level);
    }
}
