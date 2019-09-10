package com.example.practicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.practicapp.model.Pelicula;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList <Pelicula> pelicules;
    PeliculaController controller;
    PeliculaAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        controller = PeliculaController.get(this);

        pelicules = new ArrayList<>();
        adapter = new PeliculaAdapter(this,R.layout.row, pelicules);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, PeliActivity.class);
                Pelicula p = pelicules.get(position);
                String imatge = p.getImatge();
                String peliId = p.getId();


                startActivity(intent);



            }
        });

        getPelicules();

    }

    private void getPelicules(){
        pelicules.clear();
        pelicules.addAll(controller.getPelicules());
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_1:
                Intent intent1 = new Intent(MainActivity.this, InspirActivity.class);
                startActivity(intent1);
                return (true);

            case R.id.item_2:
                Intent intent2= new Intent(MainActivity.this, FormActivity.class);
                startActivity(intent2);
                return (true);
        }
        return (super.onOptionsItemSelected(item));
    }

}
