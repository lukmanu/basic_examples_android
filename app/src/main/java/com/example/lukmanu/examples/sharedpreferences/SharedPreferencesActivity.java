package com.example.lukmanu.examples.sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lukmanu.examples.R;

public class SharedPreferencesActivity extends Activity implements View.OnClickListener
{
    private static final String KEY_USUARIO = "key_usuario";
    private static final String KEY_CONTRASENNA = "key_contrasenna";

    private EditText usuarioEditText;
    private EditText contrasennaEditText;

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreferences);

        View v = findViewById(R.id.bttn_guardar);
        v.setOnClickListener(this);
        v = findViewById(R.id.bttn_mostrar);
        v.setOnClickListener(this);

        usuarioEditText = (EditText) findViewById(R.id.usuario);
        contrasennaEditText = (EditText) findViewById(R.id.contrasenna);

        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.bttn_mostrar:
                mostrar();
                break;
            case R.id.bttn_guardar:
                salvar();
                break;
        }
    }

    private void salvar()
    {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_USUARIO, usuarioEditText.getText().toString());
        editor.putString(KEY_CONTRASENNA, contrasennaEditText.getText().toString());
        editor.apply();
    }

    private void mostrar()
    {
        String usuario = prefs.getString(KEY_USUARIO, usuarioEditText.getText().toString());
        String contrasenna = prefs.getString(KEY_CONTRASENNA, contrasennaEditText.getText().toString());

        String text = "Usuario: " + usuario + " Contraseña: " + contrasenna;
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
