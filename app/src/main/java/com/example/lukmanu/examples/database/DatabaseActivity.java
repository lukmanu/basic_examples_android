package com.example.lukmanu.examples.database;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.lukmanu.examples.R;

public class DatabaseActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        //Abrimos la base de datos 'DBUsuarios' en modo escritura
        UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);
        SQLiteDatabase db = usdbh.getWritableDatabase();
        //Si hemos abierto correctamente la base de datos
        if (db != null)
        {
            //Insertamos 5 usuarios de ejemplo
            for (int i = 1; i <= 5; i++)
            {
                //Generamos los datos
                String nombre = "Usuario" + i;
                //Insertamos los datos en la tabla Usuarios
                db.execSQL("INSERT INTO Usuarios (codigo, nombre) " + "VALUES (" + i + ", '" + nombre + "')");
            }
            //Cerramos la base de datos
            db.close();
        }
    }
}
