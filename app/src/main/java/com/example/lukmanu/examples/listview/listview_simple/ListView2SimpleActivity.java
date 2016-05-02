package com.example.lukmanu.examples.listview.listview_simple;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.lukmanu.examples.R;
import com.example.lukmanu.examples.data.ListadoPersonas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListView2SimpleActivity extends Activity
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
        List<Map<String, Object>> data = prepareData();

        ListAdapter adapter = new SimpleAdapter(this, data, android.R.layout.simple_list_item_2, new String[]{"nombre", "idUsuario"}, new int[]{android.R.id.text1, android.R.id.text2});

        mListView.setAdapter(adapter);
    }

    private List<Map<String, Object>> prepareData()
    {
        List<Map<String, Object>> data = new ArrayList<>();

        Map<String, Object> item;
        int size = ListadoPersonas.getInstance().getPersonaArrayList().size();
        for (int i = 0; i < size; i++)
        {
            item = new HashMap<>();
            item.put("nombre", ListadoPersonas.getInstance().getPersonaArrayList().get(i).getNombre());
            item.put("idUsuario", ListadoPersonas.getInstance().getPersonaArrayList().get(i).getIdUsuario());
            data.add(item);
        }

        return data;
    }
}
