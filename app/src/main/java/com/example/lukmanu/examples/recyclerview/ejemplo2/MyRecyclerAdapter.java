package com.example.lukmanu.examples.recyclerview.ejemplo2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lukmanu.examples.R;
import com.example.lukmanu.examples.datamodel.personas.Persona;
import com.example.lukmanu.examples.datamodel.personas.Profesor;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    public static final int TYPE_PROFESOR = 1;
    private List<Persona> items;

    public MyRecyclerAdapter(List<Persona> items)
    {
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        if (viewType == TYPE_PROFESOR)
            return new MyViewHolderProfesor(LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_2_item, parent, false));
        else
            return new MyViewHolderPersona(LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        if (getItemViewType(position) == TYPE_PROFESOR)
        {
            Profesor profesor = (Profesor) items.get(position);
            ((MyViewHolderProfesor) holder).nombre.setText(profesor.getNombre());
            ((MyViewHolderProfesor) holder).idUsuario.setText(profesor.getIdUsuario());
            ((MyViewHolderProfesor) holder).asignatura.setText(profesor.getAsignatura());
        } else
        {
            Persona persona = items.get(position);
            ((MyViewHolderPersona) holder).nombre.setText(persona.getNombre());
            ((MyViewHolderPersona) holder).idUsuario.setText(persona.getIdUsuario());
        }
    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }

    @Override
    public int getItemViewType(int position)
    {
        return items.get(position) instanceof Profesor ? TYPE_PROFESOR : super.getItemViewType(position);
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

    public static class MyViewHolderProfesor extends RecyclerView.ViewHolder
    {
        protected TextView nombre;
        protected TextView idUsuario;
        protected TextView asignatura;

        public MyViewHolderProfesor(View itemView)
        {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            idUsuario = (TextView) itemView.findViewById(R.id.idUsuario);
            asignatura = (TextView) itemView.findViewById(R.id.asignatura);
        }
    }
}