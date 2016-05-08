package com.example.lukmanu.examples.services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lukmanu.examples.R;

public class ServiceActivity extends Activity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio);

        findViewById(R.id.startService).setOnClickListener(this);
        findViewById(R.id.stopService).setOnClickListener(this);

    }

    public void startService()
    {
        Intent serviceIntent = new Intent(this, MyBackgroundService.class);
        startService(serviceIntent);
    }

    public void stopService()
    {
        Intent serviceIntent = new Intent(this, MyBackgroundService.class);
        stopService(serviceIntent);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.startService:
                startService();
            break;
            case R.id.stopService:
                stopService();
            break;
        }
    }
}
