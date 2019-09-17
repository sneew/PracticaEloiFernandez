package com.example.practicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practicapp.model.Pelicula;

public class FormActivity extends AppCompatActivity {

    EditText et_titol, et_descripcio, et_any, et_puntuacio, et_imatge;
    PeliculaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        et_titol = findViewById(R.id.et_titol);
        et_descripcio = findViewById(R.id.et_descripcio);
        et_any = findViewById(R.id.et_any);
        et_puntuacio = findViewById(R.id.et_puntuacio);
        et_imatge = findViewById(R.id.et_imatge);

        controller = PeliculaController.get(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.form);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void createPeli(View view) {

        if (comprovar()){

            String titol = et_titol.getText().toString();
            String descripcio = et_descripcio.getText().toString();
            String any = et_any.getText().toString();
            String puntuacio = et_puntuacio.getText().toString();
            String imatge = et_imatge.getText().toString();

            Pelicula pelicula = new Pelicula(titol,descripcio,Integer.parseInt(any),Integer.parseInt(puntuacio),imatge);
            controller.addPelicula(pelicula);

            Toast.makeText(this,getString(R.string.pelicreada), Toast.LENGTH_LONG).show();

            finish();
        }
    }

    public boolean comprovar(){

        boolean chkEspais = true;

        if ("".equals(et_titol.getText().toString())){
            et_titol.setError(getString(R.string.buit));
            chkEspais = false;
        }

        if ("".equals(et_descripcio.getText().toString())) {
            et_descripcio.setError(getString(R.string.buit));
            chkEspais = false;
        }

        if ("".equals(et_any.getText().toString())) {
            et_any.setError(getString(R.string.buit));
            chkEspais = false;
        }

        if ("".equals(et_puntuacio.getText().toString())) {
            et_puntuacio.setError(getString(R.string.buit));
            chkEspais = false;
        } else {
            int dif = Integer.parseInt(et_puntuacio.getText().toString());
            if (0>dif || 5<dif){
                et_puntuacio.setError(getString(R.string.dif));
                chkEspais = false;
            }
        }

        if ("".equals( et_imatge.getText().toString())) {
            et_imatge.setError(getString(R.string.buit));
            chkEspais = false;
        }

        return chkEspais;
    }


}
