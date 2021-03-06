package com.example.lukmanu.examples.listview.listview_complejo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lukmanu.examples.R;
import com.example.lukmanu.examples.data.ListadoPersonas;
import com.example.lukmanu.examples.datamodel.personas.Persona;
import com.example.lukmanu.examples.eventviews.MyAlertDialog;

import java.util.List;

public class ListViewComplejoActivity extends Activity implements AdapterView.OnItemClickListener
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
        ListAdapter adapter = new MyAdapter(this, R.layout.listview_item, ListadoPersonas.getInstance().getPersonaArrayList());

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        MyAlertDialog.newInstance(ListadoPersonas.getInstance().getPersonaArrayList().get(position).getNombre()).show(getFragmentManager(), "dialog");
    }

    private class MyAdapter extends ArrayAdapter<Persona>
    {
        public MyAdapter(Context context, int resource, List<Persona> objects)
        {
            super(context, resource, objects);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            if (convertView == null)
                convertView = View.inflate(getContext(), R.layout.listview_item, null);

            TextView nombreTV = (TextView) convertView.findViewById(R.id.nombre);
            TextView idUsuarioTV = (TextView) convertView.findViewById(R.id.idUsuario);

            nombreTV.setText(getItem(position).getNombre());
            idUsuarioTV.setText(getItem(position).getIdUsuario());

            return convertView;
        }
    }
}
