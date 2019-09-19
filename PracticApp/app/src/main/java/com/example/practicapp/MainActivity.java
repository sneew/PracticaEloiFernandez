package com.example.practicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.practicapp.model.Pelicula;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList <Pelicula> pelicules;
    PeliculaController controller;
    PeliculaAdapter adapter;
    SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        controller = PeliculaController.get(this);
        pelicules = new ArrayList<>();
        adapter = new PeliculaAdapter(this,R.layout.row, pelicules);
        prefs = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, PeliActivity.class);

                intent.putExtra("id", pelicules.get(position).getId());

                startActivity(intent);


            }
        });

    }

    private void checkLogin() {
        String sharedMail = prefs.getString("sharedMail",null);
        String sharedpass = prefs.getString("sharedPass", null);

        if (sharedMail == null || sharedpass == null){

            Intent intent = new Intent(MainActivity.this, LoginActivity.class);

            startActivity(intent);
        } else{
            Toast.makeText(this,(getString(R.string.benvinguda) + " " + sharedMail), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkLogin();
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

    private void openPeliActivity (Pelicula p){


    }

}
