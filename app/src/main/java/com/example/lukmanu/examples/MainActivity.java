package com.example.lukmanu.examples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.lukmanu.examples.database.DatabaseActivity;
import com.example.lukmanu.examples.listview.listview_complejo.ListViewComplejoTypesActivity;
import com.example.lukmanu.examples.listview.listview_complejo.ListViewComplejoActivity;
import com.example.lukmanu.examples.listview.listview_simple.ListViewSimple2LinesActivity;
import com.example.lukmanu.examples.listview.listview_simple.ListViewSimpleActivity;
import com.example.lukmanu.examples.recyclerview.ejemplo2.RecyclerViewActivity;
import com.example.lukmanu.examples.sharedpreferences.SharedPreferencesActivity;

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
        v = findViewById(R.id.bttn_6);
        if (v != null)
            v.setOnClickListener(this);
        v = findViewById(R.id.bttn_7);
        if (v != null)
            v.setOnClickListener(this);
        v = findViewById(R.id.bttn_8);
        if (v != null)
            v.setOnClickListener(this);
        v = findViewById(R.id.bttn_9);
        if (v != null)
            v.setOnClickListener(this);
        v = findViewById(R.id.bttn_10);
        if (v != null)
            v.setOnClickListener(this);
        v = findViewById(R.id.bttn_11);
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
                intent = new Intent(this, ListViewSimple2LinesActivity.class);
                break;
            case R.id.bttn_3:
                intent = new Intent(this, ListViewComplejoActivity.class);
                break;
            case R.id.bttn_4:
                intent = new Intent(this, ListViewComplejoTypesActivity.class);
                break;
            case R.id.bttn_5:
                intent = new Intent(this, com.example.lukmanu.examples.recyclerview.ejemplo1.RecyclerViewActivity.class);
                break;
            case R.id.bttn_6:
                intent = new Intent(this, RecyclerViewActivity.class);
                break;
            case R.id.bttn_7:
                intent = new Intent(this, com.example.lukmanu.examples.recyclerview.ejemplo3.RecyclerViewActivity.class);
                break;
            case R.id.bttn_8:
                intent = new Intent(this, com.example.lukmanu.examples.recyclerview.ejemplo4.RecyclerViewActivity.class);
                break;
            case R.id.bttn_9:
                intent = new Intent(this, com.example.lukmanu.examples.recyclerview.ejemplo5.RecyclerViewActivity.class);
                break;
            case R.id.bttn_10:
                intent = new Intent(this, SharedPreferencesActivity.class);
                break;
            case R.id.bttn_11:
                intent = new Intent(this, DatabaseActivity.class);
                break;
            default:
                intent = new Intent(this, ListViewSimpleActivity.class);
                break;
        }
        startActivity(intent);
    }
}
