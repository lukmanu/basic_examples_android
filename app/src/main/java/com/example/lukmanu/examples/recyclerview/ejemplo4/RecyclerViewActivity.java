package com.example.lukmanu.examples.recyclerview.ejemplo4;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lukmanu.examples.R;
import com.example.lukmanu.examples.data.ListadoPersonas;

public class RecyclerViewActivity extends Activity
{
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        mRecyclerView = (RecyclerView) findViewById(R.id.lista);

        populate();
    }

    private void populate()
    {
        LinearLayoutManager llmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(llmanager);
        mRecyclerView.setAdapter(new MyRecyclerAdapter(this, ListadoPersonas.getInstance().getPersonaArrayList()));
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));

    }


}
