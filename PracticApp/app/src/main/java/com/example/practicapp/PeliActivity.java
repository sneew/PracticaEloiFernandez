package com.example.practicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practicapp.model.Pelicula;
import com.squareup.picasso.Picasso;

public class PeliActivity extends AppCompatActivity {

    PeliculaController controller;
    Pelicula pelicula;
    String idPeli;
    TextView tv_titol, tv_any, tv_descripcio, tv_puntuacio;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peli);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.peli);

        tv_titol = findViewById(R.id.tv_titol);
        tv_descripcio = findViewById(R.id.tv_descripcio);
        tv_any = findViewById(R.id.tv_any);
        tv_puntuacio = findViewById(R.id.tv_puntuacio);
        imageView = findViewById(R.id.imageView);

        idPeli = getIntent().getStringExtra("id");

        controller = PeliculaController.get(this);
        pelicula = controller.getPelicula(idPeli);

        mostrarPeli();
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void esborrar(View view) {
        controller.deletePelicula(pelicula);
        finish();
    }

    private void mostrarPeli(){
        tv_descripcio.setText(pelicula.getDescripcio());
        tv_titol.setText(pelicula.getTitol());
        tv_any.setText(String.valueOf(pelicula.getAny()));
        tv_puntuacio.setText(String.valueOf(pelicula.getPuntuacio()));

        String url = pelicula.getImatge();
        Picasso.get().load(url).into(imageView);
    }

}
