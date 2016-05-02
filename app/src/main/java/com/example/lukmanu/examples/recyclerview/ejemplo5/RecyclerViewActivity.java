package com.example.lukmanu.examples.recyclerview.ejemplo5;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

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
        GridLayoutManager glmanager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(glmanager);
        mRecyclerView.setAdapter(new MyRecyclerAdapter(this, ListadoPersonas.getInstance().getPersonaArrayList()));
    }


}
