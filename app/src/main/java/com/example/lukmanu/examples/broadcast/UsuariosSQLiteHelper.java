package com.example.lukmanu.examples.broadcast;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuariosSQLiteHelper extends SQLiteOpenHelper
{
    private String SQLCREATE = "CREATE TABLE Usuarios (codigo INTEGER, nombre TEXT)";

    public UsuariosSQLiteHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version)

    {
        super(contexto, nombre, factory, version);
    }


    public void onCreate(SQLiteDatabase db)


    {
        db.execSQL(SQLCREATE);
    }


    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva)


    {
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL(SQLCREATE);
    }


}
