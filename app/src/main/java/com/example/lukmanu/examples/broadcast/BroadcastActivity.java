package com.example.lukmanu.examples.broadcast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lukmanu.examples.R;

public class BroadcastActivity extends Activity
{
    private ProgressBar pb;
    private TextView tv;
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context c, Intent i)
        {
            int level = i.getIntExtra("level", 0);

            pb.setProgress(level);

            tv.setText("Battery Level: " + Integer.toString(level) + "%");
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        pb = (ProgressBar) findViewById(R.id.battery_level);
        tv = (TextView) findViewById(R.id.battery_text);

        registerReceiver(mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onDestroy()
    {
        unregisterReceiver(mBatInfoReceiver);
        super.onDestroy();
    }
}
