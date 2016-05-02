package com.example.lukmanu.examples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.lukmanu.examples.listview.listview_complejo.ListView2ComplejoActivity;
import com.example.lukmanu.examples.listview.listview_complejo.ListViewComplejoActivity;
import com.example.lukmanu.examples.listview.listview_simple.ListView2SimpleActivity;
import com.example.lukmanu.examples.listview.listview_simple.ListViewSimpleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View v;

        v = findViewById(R.id.bttn_1);
        if (v != null)
            v.setOnClickListener(this);
        v = findViewById(R.id.bttn_2);
        if (v != null)
            v.setOnClickListener(this);
        v = findViewById(R.id.bttn_3);
        if (v != null)
            v.setOnClickListener(this);
        v = findViewById(R.id.bttn_4);
        if (v != null)
            v.setOnClickListener(this);
        v = findViewById(R.id.bttn_5);
        if (v != null)
            v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        int id = v.getId();
        Intent intent;

        switch (id)
        {
            case R.id.bttn_1:
                intent = new Intent(this, ListViewSimpleActivity.class);
                break;
            case R.id.bttn_2:
                intent = new Intent(this, ListView2SimpleActivity.class);
                break;
            case R.id.bttn_3:
                intent = new Intent(this, ListViewComplejoActivity.class);
                break;
            case R.id.bttn_4:
                intent = new Intent(this, ListView2ComplejoActivity.class);
                break;
            default:
                intent = new Intent(this, ListViewSimpleActivity.class);
                break;
        }

        startActivity(intent);
    }
}
