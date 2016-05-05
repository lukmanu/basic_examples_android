package com.example.lukmanu.examples.asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.lukmanu.examples.R;

public class AsynctaskActivity extends Activity implements View.OnClickListener
{
    private MyAsynctask mTask;

    private ProgressBar progressBar;
    private ProgressBar ruleta;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);

        progressBar = (ProgressBar) findViewById(R.id.proceso_carga);
        ruleta = (ProgressBar) findViewById(R.id.progres_indeterminate);

        findViewById(R.id.start).setOnClickListener(this);
        findViewById(R.id.stop).setOnClickListener(this);
    }

    private void launchMyAsynctask()
    {
        mTask = new MyAsynctask();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
            mTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        else
            mTask.execute();
    }

    private void stopMyAsynctask()
    {
        if (mTask != null)
            mTask.cancel(true);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        stopMyAsynctask();
    }

    private void onProgres(Integer value)
    {
        progressBar.setProgress(value);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.start:
                launchMyAsynctask();
                break;
            case R.id.stop:
                stopMyAsynctask();
                break;
        }

    }

    private class MyAsynctask extends AsyncTask<Void, Integer, Void>
    {
        @Override
        protected void onPreExecute()
        {
            onProgres(0);
            ruleta.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... params)
        {
            for (int i = 0; i < 100; i++)
            {
                //TAREA EN SEGUNDO PLANO
                try
                {
                    Thread.sleep(200);
                } catch (InterruptedException ie)
                {
                }
                publishProgress(i);

                // Escape early if cancel() is called
                if (isCancelled()) break;
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values)
        {
            onProgres(values[0]);
        }

        @Override
        protected void onPostExecute(Void personas)
        {
            ruleta.setVisibility(View.INVISIBLE);
        }
    }
}
