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
import com.example.lukmanu.examples.datamodel.personas.Profesor;
import com.example.lukmanu.examples.eventviews.MyAlertDialog;

import java.util.List;

public class ListViewComplejoTypesActivity extends Activity implements AdapterView.OnItemClickListener
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
        private static final int TYPE_PROFESOR = 1;

        public MyAdapter(Context context, int resource, List<Persona> objects)
        {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            switch (getItemViewType(position))
            {
                case TYPE_PROFESOR:
                    return getViewProfesor(position, convertView, parent);
                default:
                    return getViewPersona(position, convertView, parent);
            }
        }

        private View getViewPersona(int position, View convertView, ViewGroup parent)
        {
            if (convertView == null)
                convertView = View.inflate(getContext(), R.layout.listview_item, null);

            TextView nombreTV = (TextView) convertView.findViewById(R.id.nombre);
            TextView idUsuarioTV = (TextView) convertView.findViewById(R.id.idUsuario);

            Persona persona = getItem(position);
            nombreTV.setText(persona.getNombre());
            idUsuarioTV.setText(persona.getIdUsuario());

            return convertView;
        }

        private View getViewProfesor(int position, View convertView, ViewGroup parent)
        {
            if (convertView == null)
                convertView = View.inflate(getContext(), R.layout.listview_2_item, null);

            TextView nombreTV = (TextView) convertView.findViewById(R.id.nombre);
            TextView idUsuarioTV = (TextView) convertView.findViewById(R.id.idUsuario);
            TextView asignatura = (TextView) convertView.findViewById(R.id.asignatura);

            Profesor profesor = (Profesor) getItem(position);

            nombreTV.setText(profesor.getNombre());
            idUsuarioTV.setText(profesor.getIdUsuario());
            asignatura.setText(profesor.getAsignatura());

            return convertView;
        }

        @Override
        public int getViewTypeCount()
        {
            return 2;
        }

        @Override
        public int getItemViewType(int position)
        {
            if (getItem(position) instanceof Profesor)
                return TYPE_PROFESOR;
            return super.getItemViewType(position);
        }
    }
}
