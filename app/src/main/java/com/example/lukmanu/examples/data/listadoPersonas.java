package com.example.lukmanu.examples.data;

import com.example.lukmanu.examples.datamodel.personas.Persona;

import java.util.ArrayList;

public class ListadoPersonas
{
    private static ListadoPersonas INSTANCE;
    private ArrayList<Persona> personaArrayList;

    public static ListadoPersonas getInstance()
    {
        ListadoPersonas r = INSTANCE;
        if (r == null)
        {
            synchronized (ListadoPersonas.class)
            {    // While we were waiting for the lock, another
                r = INSTANCE;        // thread may have instantiated the object.
                if (r == null)
                {
                    r = new ListadoPersonas();
                    INSTANCE = r;
                }
            }
        }
        return r;
    }

    private ListadoPersonas()
    {
        personaArrayList = new ArrayList<>(50);

        Persona persona;
        for (int i = 1; i < 51; i++)
        {
            persona = new Persona();
            persona.setNombre("Nombre " + i);
            persona.setIdUsuario("IdUsuario " + i);

            personaArrayList.add(persona);
        }
    }

    public ArrayList<Persona> getPersonaArrayList()
    {
        return personaArrayList;
    }

    public ArrayList<String> getNombresArrayList()
    {
        ArrayList<String> nombres = new ArrayList<>(50);

        for (int i = 0; i < personaArrayList.size(); i++)
            nombres.add(personaArrayList.get(i).getNombre());

        return nombres;
    }

    public ArrayList<String> getIdUsuarioArrayList()
    {
        ArrayList<String> nombres = new ArrayList<>(50);

        for (int i = 0; i < personaArrayList.size(); i++)
            nombres.add(personaArrayList.get(i).getIdUsuario());

        return nombres;
    }

}
