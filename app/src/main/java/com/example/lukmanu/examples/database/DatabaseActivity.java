package com.example.lukmanu.examples.database;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.lukmanu.examples.R;

public class DatabaseActivity extends Activity implements View.OnClickListener
{
    private TextView sqlDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        sqlDatos = (TextView) findViewById(R.id.sqldatos);
        findViewById(R.id.addBBDD).setOnClickListener(this);
        findViewById(R.id.showBBDD).setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.addBBDD:
                setUsuariosSQLiteHelper();
                break;
            case R.id.showBBDD:
                printUsuariosDatabase();
                break;
        }
    }

    private void printUsuariosDatabase()
    {
        UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);
        StringBuilder stringBuilder = new StringBuilder();
        SQLiteDatabase db = usdbh.getReadableDatabase();
        //Si hemos abierto correctamente la base de datos
        if (db != null)
        {
            Cursor c = db.rawQuery("SELECT * FROM Usuarios", null);
            c.moveToFirst();
            do
            {
                stringBuilder.append(c.getString(1)).append("\n");
            } while (c.moveToNext());
            //Cerramos la base de datos

            c.close();
            db.close();
        }

        sqlDatos.setText(stringBuilder);
    }

    private UsuariosSQLiteHelper setUsuariosSQLiteHelper()
    {
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
        return usdbh;
    }
}
