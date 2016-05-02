package com.example.lukmanu.examples.recyclerview.ejemplo3;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lukmanu.examples.R;
import com.example.lukmanu.examples.datamodel.personas.Persona;
import com.example.lukmanu.examples.datamodel.personas.Profesor;
import com.example.lukmanu.examples.eventviews.MyAlertDialog;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    public static final int TYPE_PROFESOR = 1;
    private List<Persona> items;
    private Activity activity;

    public MyRecyclerAdapter(Activity activity, List<Persona> items)
    {
        this.items = items;
        this.activity = activity;
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
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position)
    {
        final Persona persona = items.get(position);

        if (getItemViewType(position) == TYPE_PROFESOR)
        {
            ((MyViewHolderProfesor) holder).nombre.setText(persona.getNombre());
            ((MyViewHolderProfesor) holder).idUsuario.setText(persona.getIdUsuario());
            ((MyViewHolderProfesor) holder).asignatura.setText(((Profesor)persona).getAsignatura());
        } else
        {
            ((MyViewHolderPersona) holder).nombre.setText(persona.getNombre());
            ((MyViewHolderPersona) holder).idUsuario.setText(persona.getIdUsuario());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                MyAlertDialog.newInstance(persona.getNombre()).show(activity.getFragmentManager(), "dialog");
            }
        });
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