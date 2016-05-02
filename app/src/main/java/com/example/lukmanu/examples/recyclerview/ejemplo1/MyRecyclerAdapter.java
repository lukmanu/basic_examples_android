package com.example.lukmanu.examples.recyclerview.ejemplo1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lukmanu.examples.R;
import com.example.lukmanu.examples.datamodel.personas.Persona;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private List<Persona> items;

    public MyRecyclerAdapter(List<Persona> items)
    {
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new MyViewHolderPersona(LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        Persona persona = items.get(position);
        ((MyViewHolderPersona) holder).nombre.setText(persona.getNombre());
        ((MyViewHolderPersona) holder).idUsuario.setText(persona.getIdUsuario());
    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }


    public static class MyViewHolderPersona extends RecyclerView.ViewHolder
    {
        protected TextView nombre;
        protected TextView idUsuario;

        public MyViewHolderPersona(View itemView)
        {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            idUsuario = (TextView) itemView.findViewById(R.id.idUsuario);
        }
    }

}