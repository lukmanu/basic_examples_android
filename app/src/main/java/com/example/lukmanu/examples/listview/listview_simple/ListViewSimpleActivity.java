package com.example.lukmanu.examples.listview.listview_simple;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lukmanu.examples.R;
import com.example.lukmanu.examples.data.ListadoPersonas;

public class ListViewSimpleActivity extends Activity
{
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mListView = (ListView) findViewById(R.id.lista);

        populate();
    }

    private void populate()
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListadoPersonas.getInstance().getNombresArrayList());

        mListView.setAdapter(adapter);
    }
}
